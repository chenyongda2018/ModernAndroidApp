package com.cyd.modernandroidapp.inject

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication

@Module
class Module {

    @Provides
    fun provideApplicationContext(application: DaggerApplication) : Context {
        return application.applicationContext
    }
}