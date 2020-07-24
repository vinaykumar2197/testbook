package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Rating {
    @SerializedName("actual")
    @Expose
    var actual: Double? = null
    @SerializedName("value")
    @Expose
    var value: Double? = null

}