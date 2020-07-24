package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ClassInfo {
    @SerializedName("googleAdsImage")
    @Expose
    var googleAdsImage: String? = null
    @SerializedName("subjectWiseSyllabus")
    @Expose
    var subjectWiseSyllabus: SubjectWiseSyllabus? = null
    @SerializedName("classFeature")
    @Expose
    var classFeature: ClassFeature? = null
    @SerializedName("whyTakeThisCourse")
    @Expose
    var whyTakeThisCourse: WhyTakeThisCourse? = null
    @SerializedName("preRequisites")
    @Expose
    var preRequisites: PreRequisites? = null
    @SerializedName("faqs")
    @Expose
    var faqs: List<List<Faq>>? = null
    @SerializedName("testimonials")
    @Expose
    var testimonials: List<Any>? = null

}