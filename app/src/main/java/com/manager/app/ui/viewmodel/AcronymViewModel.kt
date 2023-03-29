package com.manager.app.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.manager.app.common.extenstions.showShortMessage
import com.manager.app.data.network.client.Resource
import com.manager.app.data.repository.AuthRepository
import com.manager.app.model.acronym.AcronymItem
import com.manager.app.utils.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class AcronymViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val repository: AuthRepository,
) : ViewModel() {


    //Acronym Response
    private val _responseAcronyms = MutableLiveData<Resource<ArrayList<AcronymItem>>>()
    val responseAcronyms: LiveData<Resource<ArrayList<AcronymItem>>> get() = _responseAcronyms


    /*-(1)----------------------Functions To Request Service For Acronyms --------------------------------------------*/
    fun requestToSearchAcronym(acronym: String) {
        if (NetworkUtil.hasInternetConnection(context)) {


            //Here Acronym Api Service is Calling
            viewModelScope.launch {
                _responseAcronyms.postValue(Resource.Loading)
                try {
                    val response = repository.requestToSearchAcronym(acronym)
                    _responseAcronyms.value = response

                    when (response) {
                        is Resource.Success -> {
//                            context.showShortMessage("${Gson().toJson(response.value)}")
                        }
                        is Resource.Failure -> {
                            context.showShortMessage(response.errorMessage.toString())
                        }
                        else -> {}
                    }
                } catch (ex: Exception) {
                    when (ex) {
                        is IOException -> _responseAcronyms.postValue(
                            Resource.Failure(
                                true, ex.hashCode(), null, errorMessage = "Network Error"
                            )
                        )
                        else -> _responseAcronyms.postValue(
                            Resource.Failure(
                                true, ex.hashCode(), null, errorMessage = "Conversion Error"
                            )
                        )
                    }
                }
            }
        } else {
            context.showShortMessage("No internet connection...")
        }
    }


}

