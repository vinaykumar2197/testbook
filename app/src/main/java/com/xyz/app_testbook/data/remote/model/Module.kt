package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Module {
    @SerializedName("count")
    @Expose
    var count: Count? = null

}