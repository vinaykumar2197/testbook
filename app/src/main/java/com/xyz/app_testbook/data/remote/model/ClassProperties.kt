package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ClassProperties {
    @SerializedName("subjects")
    @Expose
    var subjects: List<Any>? = null
    @SerializedName("classType")
    @Expose
    var classType: ClassType? = null
    @SerializedName("instructors")
    @Expose
    var instructors: List<Instructor>? = null
    @SerializedName("privateDiscussionUrl")
    @Expose
    var privateDiscussionUrl: String? = null
    @SerializedName("languageInfo")
    @Expose
    var languageInfo: String? = null
    @SerializedName("languagesInfo")
    @Expose
    var languagesInfo: String? = null
    @SerializedName("seatsAvailsInfo")
    @Expose
    var seatsAvailsInfo: String? = null
    @SerializedName("showLiveCourseTag")
    @Expose
    var showLiveCourseTag: Boolean? = null
    @SerializedName("curriculum")
    @Expose
    var curriculum: Curriculum? = null
    @SerializedName("contentDuration")
    @Expose
    var contentDuration: Int? = null

}