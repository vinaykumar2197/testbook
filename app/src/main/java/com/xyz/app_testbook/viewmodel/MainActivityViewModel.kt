package com.xyz.app_testbook.viewmodel

import androidx.lifecycle.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.xyz.app_testbook.repo.LiveRepo

import java.util.ArrayList

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val searchQueryChatMutableLiveData  = MutableLiveData<String>()
    var searchStatus  = false
    //  val  chatRepository:ChatRepository = ChatRepository(application)
    val  chatListRepository = LiveRepo(application)

    var botId :Int? = null
    var cid :Int? = null
    var next :Int? = null

    fun getLivePrepData() =chatListRepository.getLivePrepData()


    fun getPrepStatus()=chatListRepository.getPrepStatus()

}