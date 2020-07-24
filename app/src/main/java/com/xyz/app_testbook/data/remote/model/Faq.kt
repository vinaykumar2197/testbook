package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Faq {
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("question")
    @Expose
    var question: String? = null
    @SerializedName("answer")
    @Expose
    var answer: String? = null

}