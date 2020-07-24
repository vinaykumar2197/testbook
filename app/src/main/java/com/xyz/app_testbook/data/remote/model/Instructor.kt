package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Instructor {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("shortBio")
    @Expose
    var shortBio: String? = null
    @SerializedName("fullBio")
    @Expose
    var fullBio: String? = null

}