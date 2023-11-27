package com.example.carcaddy.screens.how_to

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.screens.how_to.composables.Step
import com.example.carcaddy.screens.how_to.composables.StepComponent

@Composable
fun CheckBrakes(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the car on level ground\n" +
                    "and turn off the engine."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Look through the wheel spokes\n" +
                    "to locate the brake pads."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Check the thickness of the brake pads,\n" +
                    "they should be at least 1/4 inch thick."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Check for wear indicators, these are\n" +
                    "small metal tabs on the pads that will\n" +
                    "touch the rotor when the pads are worn down."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "If the pads are worn or the wear\n" +
                    "indicators are touching the rotor,\n" +
                    "it's time to replace the brake pads."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Repeat for the other wheels."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "If you're not sure about the condition\n" +
                    "of your brake pads, have them inspected\n" +
                    "by a professional mechanic."
        ),
        Step(
            id = 8, number = "Disclaimer", description =
            "Remember, these steps are a general\n" +
                    "guide. We recommend consulting your\n" +
                    "vehicle's specific manual or manufacturer\n" +
                    "for precise instructions."
        ),
    )

    Column {
        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(steps) { step ->
                StepComponent(step = step)
            }
        }
    }
}