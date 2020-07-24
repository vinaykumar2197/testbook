package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Data {
    @SerializedName("classes")
    @Expose
    var classes: List<Class>? = null

}