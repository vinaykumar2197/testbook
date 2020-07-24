package com.xyz.app_testbook.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Class {
    @SerializedName("_id")
    @Expose
    var id: String? = null
    @SerializedName("course")
    @Expose
    var course: Course? = null
    @SerializedName("specificExams")
    @Expose
    var specificExams: List<SpecificExam>? = null
    @SerializedName("courses")
    @Expose
    var courses: List<Course_>? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("titles")
    @Expose
    var titles: String? = null
    @SerializedName("descriptions")
    @Expose
    var descriptions: Any? = null
    @SerializedName("shortDesc")
    @Expose
    var shortDesc: Any? = null
    @SerializedName("coachingName")
    @Expose
    var coachingName: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("isClassCombo")
    @Expose
    var isClassCombo: Boolean? = null
    @SerializedName("items")
    @Expose
    var items: Any? = null
    @SerializedName("oldCost")
    @Expose
    var oldCost: Int? = null
    @SerializedName("minCost")
    @Expose
    var minCost: Int? = null
    @SerializedName("cost")
    @Expose
    var cost: Int? = null
    @SerializedName("costUpfront")
    @Expose
    var costUpfront: Boolean? = null
    @SerializedName("weight")
    @Expose
    var weight: Int? = null
    @SerializedName("releaseDate")
    @Expose
    var releaseDate: String? = null
    @SerializedName("availTill")
    @Expose
    var availTill: String? = null
    @SerializedName("offerStart")
    @Expose
    var offerStart: String? = null
    @SerializedName("offerEnd")
    @Expose
    var offerEnd: String? = null
    @SerializedName("lastFreezedOn")
    @Expose
    var lastFreezedOn: String? = null
    @SerializedName("createdOn")
    @Expose
    var createdOn: String? = null
    @SerializedName("stage")
    @Expose
    var stage: String? = null
    @SerializedName("features")
    @Expose
    var features: Any? = null
    @SerializedName("extraFeatures")
    @Expose
    var extraFeatures: Any? = null
    @SerializedName("recommendedFor")
    @Expose
    var recommendedFor: String? = null
    @SerializedName("discountText")
    @Expose
    var discountText: String? = null
    @SerializedName("isRecommended")
    @Expose
    var isRecommended: Boolean? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null
    @SerializedName("numPurchased")
    @Expose
    var numPurchased: Int? = null
    @SerializedName("minPrice")
    @Expose
    var minPrice: Int? = null
    @SerializedName("isCustom")
    @Expose
    var isCustom: Boolean? = null
    @SerializedName("showSyllabus")
    @Expose
    var showSyllabus: Boolean? = null
    @SerializedName("slugUrl")
    @Expose
    var slugUrl: String? = null
    @SerializedName("freeTestCount")
    @Expose
    var freeTestCount: Int? = null
    @SerializedName("isHidden")
    @Expose
    var isHidden: Boolean? = null
    @SerializedName("courseLogo")
    @Expose
    var courseLogo: String? = null
    @SerializedName("classProperties")
    @Expose
    var classProperties: ClassProperties? = null
    @SerializedName("classInfo")
    @Expose
    var classInfo: ClassInfo? = null
    @SerializedName("postNote")
    @Expose
    var postNote: Any? = null
    @SerializedName("stopEvents")
    @Expose
    var stopEvents: Boolean? = null
    @SerializedName("affiliateAttributionPaused")
    @Expose
    var affiliateAttributionPaused: Boolean? = null
    @SerializedName("publishCompleted")
    @Expose
    var publishCompleted: Boolean? = null
    @SerializedName("isOffer")
    @Expose
    var isOffer: Boolean? = null
    @SerializedName("isDemoModuleAvail")
    @Expose
    var isDemoModuleAvail: Boolean? = null
    @SerializedName("isCuratedTopic")
    @Expose
    var isCuratedTopic: Boolean? = null
    @SerializedName("lastUpdatedOn")
    @Expose
    var lastUpdatedOn: String? = null
    @SerializedName("summary")
    @Expose
    var summary: Summary? = null
    @SerializedName("target")
    @Expose
    var target: List<Target>? = null
    @SerializedName("targetSuperGroup")
    @Expose
    var targetSuperGroup: List<TargetSuperGroup>? = null
    @SerializedName("thumbnailInfo")
    @Expose
    var thumbnailInfo: ThumbnailInfo? = null
    @SerializedName("doubtTag")
    @Expose
    var doubtTag: DoubtTag? = null

}