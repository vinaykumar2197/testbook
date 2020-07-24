package com.xyz.app_testbook.di.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.xyz.app_testbook.TestBookApp
import com.xyz.app_testbook.data.remote.ApiConstants
import com.xyz.app_testbook.data.remote.ApiInterface
import com.xyz.app_testbook.data.remote.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

@Module
class ApiServiceModule(val application: TestBookApp) {

    @Provides
    fun getContext(): Context = application

    @Provides
    fun apiService(retofit: Retrofit): ApiInterface {
        return retofit.create(ApiInterface::class.java)
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(ApiConstants.BASE_URL)
            .build()
    }

    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
//        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeConverter())
        return gsonBuilder.create()
    }

    @Provides
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(object : NetworkConnectionInterceptor() {
                override fun isInternetAvailable(): Boolean {
                    return application.isInternetAvailable()
                }

                override fun onInternetUnavailable() {
                    Log.e("MODULE ", "Not connected to internet")
                    if (application.mInternetConnectionListener != null)
                        application.mInternetConnectionListener!!.onInternetUnavailable()
                }

                override fun onCacheUnavailable() {
                    Log.e("MODULE ", "Catche Not available")
                }

            })
            .readTimeout(60, TimeUnit.SECONDS)
//            .cache(cache)
            .build()
    }

    @Provides
    fun loggingInterceptor(logger: HttpLoggingInterceptor.Logger): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(logger)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun getLogger(): HttpLoggingInterceptor.Logger {
        val logger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag("OkHttp").d(message)
            }
        }
        return logger
    }
}