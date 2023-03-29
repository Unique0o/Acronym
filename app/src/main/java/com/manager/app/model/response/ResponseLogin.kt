package com.manager.app.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseLogin(
    @SerializedName("phoneNumber")
    var phoneNumber: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("jwtToken")
    var jwtToken: String? = null,
    @SerializedName("userId")
    var userId: String? = null,
    @SerializedName("expiryTimeInMinutes")
    var expiryTimeInMinutes: Any? = null,
    @SerializedName("refreshToken")
    var refreshToken: String? = null,
    @SerializedName("message")
    var message: String? = null,
)