package com.example.projektamrheal.data.remote.retrofit

import com.example.projektamrheal.data.endpoint.EndPoint
import com.example.projektamrheal.data.remote.api.EventApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(EndPoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val eventApi: EventApi by lazy {
        retrofit.create(EventApi::class.java)
    }
}