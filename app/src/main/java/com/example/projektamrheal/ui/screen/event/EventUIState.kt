package com.example.projektamrheal.ui.screen.event

import com.example.projektamrheal.data.model.response.Event

data class EventUiState(
    val events: List<Event> = emptyList(),
    val likedEventIds: Set<String> = emptySet(),
    val isLoading: Boolean = true,
    val isError: Boolean = false
)