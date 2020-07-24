package com.xyz.app_testbook.data.remote


import com.xyz.app_testbook.data.remote.ApiConstants.POPULAR_COURSE
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    @GET(POPULAR_COURSE)
    fun getLivePrepData(
        @Path("bot_id") botId: Int?,
        @Query("cid") cid: Int?
    ) : Observable<PreviewModel>


}