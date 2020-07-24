package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PreRequisites {
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("comments")
    @Expose
    var comments: List<String>? = null

}