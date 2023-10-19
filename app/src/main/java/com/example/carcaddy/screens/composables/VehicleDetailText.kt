package com.example.carcaddy.screens.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun VehicleDetailText(
    text: String?,
) {
    text?.let {
        Text(
            text = it,
            fontSize = 22.sp,
        )
    }
}