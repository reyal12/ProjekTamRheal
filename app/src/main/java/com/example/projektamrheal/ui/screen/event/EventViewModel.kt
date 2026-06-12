package com.example.projektamrheal.ui.screen.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projektamrheal.data.repository.EventRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    private val repository = EventRepository()
    private val _uiState = MutableStateFlow(EventUiState())
    val uiState: StateFlow<EventUiState> = _uiState.asStateFlow()

    init {
        loadEvents()
    }

    fun loadEvents() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, isError = false) }
            
            delay(2000)
            
            try {
                val listResult = repository.getEvents()
                _uiState.update { 
                    it.copy(
                        events = listResult,
                        recommendedEvents = listResult.shuffled().take(3), // Mengambil 3 event acak sebagai rekomendasi
                        isLoading = false,
                        isError = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isLoading = false, 
                        isError = true
                    ) 
                }
            }
        }
    }

    fun toggleLike(eventName: String) {
        _uiState.update { currentState ->
            val newLikedIds = if (currentState.likedEventIds.contains(eventName)) {
                currentState.likedEventIds - eventName
            } else {
                currentState.likedEventIds + eventName
            }
            currentState.copy(likedEventIds = newLikedIds)
        }
    }
}
