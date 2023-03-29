package com.manager.app.model.acronym

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class AcronymItem(
    @SerializedName("sf")
    var sf: String? = "",
    @SerializedName("lfs")
    var lfs: ArrayList<LfsItem>? = ArrayList())