package com.example.projektamrheal.ui.screen.event

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projektamrheal.data.model.response.Event
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(
    viewModel: EventViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var selectedEvent by remember { mutableStateOf<Event?>(null) }

    BackHandler(enabled = selectedEvent != null) {
        selectedEvent = null
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            if (!uiState.isLoading) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = if (selectedEvent == null) "InfoEvent" else "Detail Event",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    navigationIcon = {
                        if (selectedEvent != null) {
                            IconButton(onClick = { selectedEvent = null }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                            }
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (selectedEvent == null) {
                EventContent(
                    uiState = uiState,
                    onRetry = { viewModel.loadEvents() },
                    onEventClick = { event -> selectedEvent = event }
                )
            } else {
                EventDetailScreen(
                    event = selectedEvent!!,
                    onRegisterSuccess = { message ->
                        scope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }
                )
            }
        }
    }
}
