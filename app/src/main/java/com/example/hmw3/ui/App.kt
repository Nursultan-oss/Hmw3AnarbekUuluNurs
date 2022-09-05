package com.example.hmw3.ui

import android.app.Application
import com.example.hmw3.ui.internet.PixabayApi
import com.example.hmw3.ui.internet.RetrofitService

class App:Application() {
    companion object{
     lateinit var api : PixabayApi
    }

    override fun onCreate() {
        super.onCreate()
   var retrofitService=RetrofitService()
   api= retrofitService.getApi()
    }
}