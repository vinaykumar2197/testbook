package com.xyz.app_testbook.data.remote
import android.os.Build
import com.xyz.app_testbook.BuildConfig


object ApiConstants {

    const val BASE_URL = "https://api.testbook.com"
//    https://api.testbook.com/api/v1/popular-courses?isPremium=FALSE&includelndividual=true
//    const val POPULAR_COURSE = "/api/v1/popular-courses?isPremium=FALSE&includelndividual=true"
    const val POPULAR_COURSE = "/api/v1/popular-courses?X-Tb-Client=tbapp,1.2&language=English&isPremium=true&includeIndividual=true"
}