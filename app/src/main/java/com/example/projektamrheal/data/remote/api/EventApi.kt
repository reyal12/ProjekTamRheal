package com.example.projektamrheal.data.remote.api

import com.example.projektamrheal.data.model.response.Event
import retrofit2.http.GET

interface EventApi {
    @GET("events.json")
    suspend fun getEvents(): List<Event>
}