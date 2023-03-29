package com.manager.app.data.network.client


import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor () : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

//        val token = MyApplication.getApp()?.tokenResponse?.accessToken
//        val token = ""
//        token?.let {
//           requestBuilder.addHeader("Authorization", "Bearer $it")
//        }

//       token?.let {
//           requestBuilder.addHeader("Authorization", "Bearer $it")
//       }?: run {
//           requestBuilder.addHeader("Authorization", "Bearer ${MyApplication.getApp()?.tokenResponse?.accessToken}")
//       }

        return chain.proceed(requestBuilder.build())
    }
}
