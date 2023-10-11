package com.example.carcaddy.screens.splash_screen

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavOptionsBuilder
import com.example.carcaddy.screens.destinations.VehicleDetailsScreenDestination
import com.example.carcaddy.utils.VehicleTestData
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Add logo, animation, or any other content here

        // Navigate to the next screen
        LaunchedEffect(Unit) {
            delay(2000) // Adjust the delay as needed
            navigator.navigate(
                direction = VehicleDetailsScreenDestination // Call your navigation function here
            )
        }
    }
}