package com.manager.app.data.repository

import com.manager.app.data.network.api.ApiService
import com.manager.app.data.network.client.SafeApiCall
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val api: ApiService,
) : SafeApiCall {

    suspend fun requestToSearchAcronym(acronym: String) = safeApiCall {
        api.requestToSearchAcronym(acronym)
    }


}
