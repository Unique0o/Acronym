package com.manager.app.model.acronym

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VarsItem(
    @SerializedName("freq")
    var freq: Long = 0,
    @SerializedName("lf")
    var lf: String? = "",
    @SerializedName("since")
    var since: Long = 0
)