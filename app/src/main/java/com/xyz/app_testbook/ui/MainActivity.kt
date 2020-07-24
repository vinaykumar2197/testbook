package com.xyz.app_testbook.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.xyz.app_testbook.R
import com.xyz.app_testbook.adapter.PrepAdapter
import com.xyz.app_testbook.base.BaseActivity
import com.xyz.app_testbook.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : BaseActivity() {

    lateinit var adapter: PrepAdapter

    lateinit var  viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        adapter = PrepAdapter()
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getLivePrepData()

        viewModel.getPrepStatus().observe(this, Observer {
            if (it!=null){
//                Timber.e("data inserted successfully")
                adapter.submitList(conversationList)
            }
            else{
//                Timber.e("Not yet")
            }
        })
    }


}
