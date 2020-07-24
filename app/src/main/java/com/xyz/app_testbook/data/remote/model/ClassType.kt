package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ClassType {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("classFrom")
    @Expose
    var classFrom: String? = null
    @SerializedName("classTill")
    @Expose
    var classTill: String? = null
    @SerializedName("lastEnrollmentDate")
    @Expose
    var lastEnrollmentDate: String? = null
    @SerializedName("courseDuration")
    @Expose
    var courseDuration: Long? = null

}