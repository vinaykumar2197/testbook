package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ThumbnailInfo {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

}