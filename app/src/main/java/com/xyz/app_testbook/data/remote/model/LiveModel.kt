package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LiveModel {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null
    @SerializedName("data")
    @Expose
    var data: Data? = null
    @SerializedName("curTime")
    @Expose
    var curTime: String? = null

}