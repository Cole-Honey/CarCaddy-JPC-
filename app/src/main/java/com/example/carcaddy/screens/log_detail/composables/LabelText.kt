package com.example.carcaddy.screens.log_detail.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(
    text: String
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = Color.Gray
    )
}