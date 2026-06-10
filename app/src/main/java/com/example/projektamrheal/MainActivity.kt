package com.example.projektamrheal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.projektamrheal.ui.screen.event.EventScreen
import com.example.projektamrheal.ui.theme.ProjekTamRhealTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjekTamRhealTheme {
                EventScreen()
            }
        }
    }
}
