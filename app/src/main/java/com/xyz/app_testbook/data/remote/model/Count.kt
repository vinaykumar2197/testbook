package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Count {
    @SerializedName("Doubt Class")
    @Expose
    var doubtClasses: Int? = null
    @SerializedName("Live Class")
    @Expose
    var liveClasses: Int? = null
    @SerializedName("Notes")
    @Expose
    var notes: Int? = null
    @SerializedName("Quiz")
    @Expose
    var quiz: Int? = null
    @SerializedName("Video")
    @Expose
    var video: Int? = null
    @SerializedName("Practice")
    @Expose
    var practice: Int? = null

}