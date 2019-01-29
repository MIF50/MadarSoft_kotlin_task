package com.mif50.madarsoftkotlin.app

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.mif50.madarsoftkotlin.BuildConfig
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.mif50.madarsoftkotlin.di.ApplicationModules.modules
import okhttp3.OkHttpClient
import org.koin.android.ext.android.startKoin


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
class App: Application(){

    override fun onCreate() {
        super.onCreate()

        initDi()
        initNetworking()
    }


    private fun initNetworking(){
        val client =  OkHttpClient.Builder()
            .build()
        AndroidNetworking.initialize(this,client)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
    private fun  initDi(){
        startKoin(this, modules)
    }

//    private fun initPrefs(){
//        SecurePrefManagerInit.Initializer(applicationContext)
//            .useEncryption(true)
//            .initialize()
//    }
}