package com.xyz.app_testbook.base

import android.app.Application
import androidx.lifecycle.MutableLiveData
import android.widget.Toast
import com.xyz.app_testbook.TestBookApp
import com.xyz.app_testbook.data.remote.ApiInterface
import com.xyz.app_testbook.local.AppDatabase
import com.xyz.app_testbook.local.UserSharedPrefs
import javax.inject.Inject

open class BaseRepo {

    @Inject
    lateinit var apiService: ApiInterface

    @Inject
    lateinit var userSharedPrefs: UserSharedPrefs


    constructor(application: Application) {
        (application as TestBookApp).component?.inject(this)
    }

    var mutableStates = MutableLiveData<STATE>()
    var apiMessage = "Network Error..."
    var apiData=""


    @Inject lateinit var appDatabase: AppDatabase

    enum class STATE {
        SUCCESS,
        FAILURE,
        NEUTRAL
    }


}