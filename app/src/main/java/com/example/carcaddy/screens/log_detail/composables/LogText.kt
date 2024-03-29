package com.example.carcaddy.screens.log_detail.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun LogText(
    text: String?
) {
    text?.let {
        Text(
            text = it,
            fontSize = 24.sp
        )
    }
}