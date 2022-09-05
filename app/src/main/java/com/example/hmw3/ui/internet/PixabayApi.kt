package com.example.hmw3.ui.internet


import com.example.hmw3.ui.model.PixabayModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {


        @GET("api/")
        fun getImagesByWord(
            @Query("key") key: String = "28971822-35022383c0475f4deeeee565f",
            @Query("q") keyWord: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int = 10
        ): retrofit2.Call<PixabayModel>

    }
