package com.example.carcaddy.screens.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        color = Color.Gray
    )
}
