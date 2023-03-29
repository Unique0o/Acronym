package com.manager.app.data.repository

import com.manager.app.data.network.api.BaseApi
import com.manager.app.data.network.client.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {

    suspend fun logout() = safeApiCall {
    }


}
