package com.uala.test

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.uala.test.inject.dataModule
import com.uala.test.inject.domainModule
import com.uala.test.inject.presentationModule
import com.uala.test.inject.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin



class App : Application() {



    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(presentationModule, remoteModule, domainModule, dataModule))
        }
        //DataBindingUtil.setDefaultComponent(BindingComponent())
    }
}