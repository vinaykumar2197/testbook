package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ClassFeature {
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("features")
    @Expose
    var features: List<Feature>? = null

}