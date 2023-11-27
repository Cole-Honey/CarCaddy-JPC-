package com.example.carcaddy.screens.maintenance.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun LogText(
    text: String?
) {
    text?.let {
        Text(
            text = it,
            fontSize = 20.sp
        )
    }
}