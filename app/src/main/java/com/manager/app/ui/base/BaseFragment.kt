package com.manager.app.ui.base

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.manager.app.R
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.ParameterizedType


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding>(private val bindingInflater: (layoutInflater: LayoutInflater) -> VB) :
    Fragment() {

    private var alertDialogProgressBar: AlertDialog? = null
    private var progressDialog: Dialog? = null
    private var isActivityPaused: Boolean? = false


    private var _binding: VB? = null
    val binding get() = _binding!!


    /*   private fun getViewModelClass(): Class<VM> {
           val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
           return type as Class<VM>
       }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adb = AlertDialog.Builder(requireContext())
        val view: View = layoutInflater.inflate(R.layout.alert_dialog_progressbar_layout, null)
        adb.setView(view)
        alertDialogProgressBar = adb.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initProgressDialog()
    }

    private fun initProgressDialog() {
        progressDialog = Dialog(requireContext())
        progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog!!.setContentView(R.layout.alert_dialog_progressbar_layout)
        progressDialog!!.setCancelable(false)
    }

    protected open fun showProgress() {
        if (isActivityPaused!!) {
            return
        }
        progressDialog!!.show()
    }

    protected open fun hideProgress() {
        if (isActivityPaused!!) {
            return
        }
        progressDialog!!.dismiss()
    }

    /*--Loader Functions--*/
    protected open fun showLoadingProgressBar(message: String?, cancelable: Boolean) {
        if (isActivityPaused!!) return

        alertDialogProgressBar!!.setCancelable(cancelable)
        alertDialogProgressBar!!.show()
    }

    protected open fun closeProgressBar() {
        if (alertDialogProgressBar == null) {
            return
        }
        alertDialogProgressBar!!.hide()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPause() {
        super.onPause()
        isActivityPaused = true
    }

    override fun onResume() {
        super.onResume()
        isActivityPaused = false
    }

    override fun onDestroy() {
        super.onDestroy()
        isActivityPaused = true
    }
}