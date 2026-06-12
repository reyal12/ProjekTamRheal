package com.example.projektamrheal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.projektamrheal.ui.screen.event.EventScreen
import com.example.projektamrheal.ui.screen.login.LoginScreen
import com.example.projektamrheal.ui.screen.splash.SplashScreen
import com.example.projektamrheal.ui.theme.ProjekTamRhealTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjekTamRhealTheme {
                var currentScreen by remember { mutableStateOf("splash") }

                when (currentScreen) {
                    "splash" -> SplashScreen(onTimeout = { currentScreen = "login" })
                    "login" -> LoginScreen(onLoginSuccess = { currentScreen = "main" })
                    "main" -> EventScreen()
                }
            }
        }
    }
}
