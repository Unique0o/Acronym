package com.manager.app.data.network.client

import com.manager.app.common.extenstions.getString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException  -> {
                        if(throwable.code()==400){
                            Resource.Failure(false, throwable.code(), throwable.response()?.errorBody(),throwable.response()?.errorBody().getString("error"))

                        }else{
                            Resource.Failure(false, throwable.code(), throwable.response()?.errorBody(),throwable.response()?.message())
                        }
                    }
                    is UnknownHostException -> {
                        Resource.Failure(false, null, null,throwable.localizedMessage)
                    }
                    else -> {
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }
    }
}
