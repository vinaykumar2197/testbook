package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Course_ {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null

}