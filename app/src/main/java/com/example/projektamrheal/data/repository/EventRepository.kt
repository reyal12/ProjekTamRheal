package com.example.projektamrheal.data.repository

import com.example.projektamrheal.data.model.response.Event
import com.example.projektamrheal.data.remote.retrofit.RetrofitClient

class EventRepository {
    suspend fun getEvents(): List<Event> {
        return RetrofitClient.eventApi.getEvents()
    }
}