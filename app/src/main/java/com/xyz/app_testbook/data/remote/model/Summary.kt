package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Summary {
    @SerializedName("rating")
    @Expose
    var rating: Rating? = null
    @SerializedName("module")
    @Expose
    var module: Module? = null

}