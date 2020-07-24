package com.xyz.app_testbook.di.component

import com.xyz.app_testbook.TestBookApp
import com.xyz.app_testbook.base.BaseActivity
import com.xyz.app_testbook.base.BaseRepo
import com.xyz.app_testbook.di.module.ApiServiceModule
import com.xyz.app_testbook.di.module.AppDatabaseModule
import dagger.Component

@Component(modules = arrayOf(ApiServiceModule::class, AppDatabaseModule::class))
interface ApplicationComponent {
    fun inject(application: TestBookApp)
    fun inject(baseActivity: BaseActivity)
    fun inject(baseRepo: BaseRepo)
}