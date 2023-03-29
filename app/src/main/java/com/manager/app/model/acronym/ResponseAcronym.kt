package com.manager.app.model.acronym

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseAcronym(
    @SerializedName("ResponseAcromine")
    var responseAcronym: List<AcronymItem>? = ArrayList()
)