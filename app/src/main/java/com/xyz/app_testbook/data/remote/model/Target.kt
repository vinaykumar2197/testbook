package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Target {
    @SerializedName("_id")
    @Expose
    var id: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("isPrimary")
    @Expose
    var isPrimary: Boolean? = null

}