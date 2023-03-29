package com.manager.app.data.network.api

import com.manager.app.model.acronym.AcronymItem
import com.manager.app.model.acronym.ResponseAcronym
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiService : BaseApi {

    //(1)-Request To Generate Acronym

    @GET("dictionary.py")
    suspend fun requestToSearchAcronym(
        @Query("sf") acronym: String? = "",
    ): ArrayList<AcronymItem>

}
