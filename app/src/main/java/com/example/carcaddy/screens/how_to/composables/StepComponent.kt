package com.example.carcaddy.screens.how_to.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StepComponent(step: Step) {
    ElevatedCard(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .width(200.dp) // Adjust the width based on your design
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "-${step.number}-")

            Text(text = step.description)
        }
    }
}