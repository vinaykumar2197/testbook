package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Feature {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("showInSummary")
    @Expose
    var showInSummary: Boolean? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null

}