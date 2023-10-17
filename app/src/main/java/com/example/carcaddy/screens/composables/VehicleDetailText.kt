package com.example.carcaddy.screens.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun VehicleDetailText(
    text: String?,
) {
    text?.let {
        Text(text = it)
    }
}