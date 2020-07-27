package com.xyz.app_testbook.ui

import android.graphics.*
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.sdsmdg.harjot.vectormaster.models.PathModel
import com.xyz.app_testbook.R
import com.xyz.app_testbook.adapter.PrepAdapter
import com.xyz.app_testbook.base.BaseActivity
import com.xyz.app_testbook.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.min


class MainActivity : BaseActivity() {

    lateinit var adapter: PrepAdapter

    lateinit var  viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDialog(true, true)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        adapter = PrepAdapter()
//        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        viewModel.getLivePrepData()

        viewModel.getPrepStatus().observe(this, Observer {
            if (it.success!!){
//                Timber.e("data inserted successfully")
                setDialog(false, true)

                userSharedPrefs.setCurrentDate(it.curTime)

                adapter.submitList(it.data!!.classes!!)
            }
            else{
//                Timber.e("Not yet")
            }
        })
    }


}
