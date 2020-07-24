package com.xyz.app_testbook.di.module

import android.content.Context
import android.content.SharedPreferences
import com.xyz.app_testbook.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDatabaseModule(val context: Context) {
    @Provides
    fun appDatabase(context: Context): AppDatabase = AppDatabase.getDatabase(context)

}