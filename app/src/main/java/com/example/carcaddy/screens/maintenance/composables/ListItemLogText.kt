package com.example.carcaddy.screens.maintenance.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun ListItemLogText(
    text: String?
) {
    text?.let {
        Text(
            text = it,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}