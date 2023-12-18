package com.example.carcaddy.screens.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carcaddy.screens.navigation.Directions
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Add logo, animation, or any other content here
        Text(
            text = "Car Caddy",
            fontSize = 45.sp
        )

        // Navigate to the next screen
        LaunchedEffect(Unit) {
            delay(3000) // Adjust the delay as needed
            navController.navigate(Directions.MyGarage.path)
        }
    }
}