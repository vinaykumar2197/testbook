package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Curriculum {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("title")
    @Expose
    var title: Any? = null
    @SerializedName("url")
    @Expose
    var url: Any? = null

}