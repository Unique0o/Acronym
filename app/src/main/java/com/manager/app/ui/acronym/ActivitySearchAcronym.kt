package com.manager.app.ui.acronym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.manager.app.common.extenstions.hideKeyboard
import com.manager.app.common.extenstions.showShortMessage
import com.manager.app.data.network.client.Resource
import com.manager.app.databinding.ActivitySearchBinding
import com.manager.app.ui.adapter.AdapterAcronym
import com.manager.app.ui.viewmodel.AcronymViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivitySearchAcronym : AppCompatActivity() {


    //ViewModel
    private val viewModel by viewModels<AcronymViewModel>()

    //Binding
    private lateinit var binding: ActivitySearchBinding

    //Adapter
    private val adapter by lazy {AdapterAcronym(ArrayList())}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        clickListeners()
    }

    private fun initUI() {
        binding.rvList.adapter = adapter
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.responseAcronyms.observe(this) { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.rvList.isVisible = false
                    binding.progressBar.isVisible = true
                }
                is Resource.Success -> {

                    binding.rvList.isVisible = false
                    binding.progressBar.isVisible = false

                    if (response.value.isEmpty()) {
                        binding.rvList.isVisible = false
                        binding.tvNoDataFound.isVisible = true
                    } else {

                        binding.rvList.isVisible = true
                        binding.tvNoDataFound.isVisible = false
                        adapter.updateList(response.value[0].lfs!!)
                    }
                }
                is Resource.Failure -> {
                    this.showShortMessage("${response.errorMessage}")
                    binding.progressBar.isVisible = false
                    binding.rvList.isVisible = false
                    binding.tvNoDataFound.isVisible = true

                }
            }
        }
    }

    private fun clickListeners() {
        binding.btnSearch.setOnClickListener {
            this.hideKeyboard()
            viewModel.requestToSearchAcronym(binding.etSearchAcronym.text.toString().trim())
        }
    }

}