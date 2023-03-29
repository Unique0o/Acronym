package com.manager.app.data.network.client

import com.manager.app.BuildConfig
import com.manager.app.MyApplication
import com.manager.app.R
import com.manager.app.common.extenstions.getString
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RemoteDataSource {

    fun <Api> buildApi(api: Class<Api>): Api {
        return Retrofit.Builder().baseUrl(MyApplication.getApp()?.applicationContext?.getString(R.string.base_url)?:"").client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create()).build().create(api)
    }

    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(NetworkConnectionInterceptor(MyApplication.getApp()!!.applicationContext))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }).build()
    }


}
