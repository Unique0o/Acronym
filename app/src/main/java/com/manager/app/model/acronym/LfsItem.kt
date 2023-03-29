package com.manager.app.model.acronym

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LfsItem(
    @SerializedName("freq")
    var freq: Long = 0,

    @SerializedName("lf")
    var title: String? = "",

    @SerializedName("vars")
    var vars: List<VarsItem>? = ArrayList(),

    @SerializedName("since")
    var since: Long = 0
)