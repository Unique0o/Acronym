package com.manager.app.model.response

import com.google.gson.annotations.SerializedName

data class
ResponseMessage(
    @SerializedName("message") var message: String? = "",
    @SerializedName("error") var error: String? = ""
)



