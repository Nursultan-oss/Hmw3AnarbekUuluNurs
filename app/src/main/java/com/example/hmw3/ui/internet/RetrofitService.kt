package com.example.hmw3.ui.internet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {
    val retrofit=Retrofit.Builder().baseUrl("https://pixabay.com/").addConverterFactory(GsonConverterFactory.create()).build()

    fun getApi():PixabayApi=retrofit.create(PixabayApi::class.java)
}