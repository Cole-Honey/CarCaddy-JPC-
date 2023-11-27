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
fun CheckOil(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(id = 1, number = "Step 1", description = "Park the car on level ground."),
        Step(id = 2, number = "Step 2", description = "Locate the dipstick and remove it."),
        Step(id = 3, number = "Step 3", description = "Wipe the dipstick clean"),
        Step(
            id = 4, number = "Step 4", description =
            "Reinsert the dipstick fully\n" +
                    "back into the oil reservoir."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Remove the dipstick again and\n" +
                    "check the oil levelagainst the\n" +
                    "minimum and maximum markings."
        ),
        Step(id = 6, number = "Step 6", description = "Check the oil color and consistency."),
        Step(
            id = 7, number = "Step 7", description =
            "If the oil level is low, top it off.\n" +
                    "If the oil is dirty, it may be time\n" +
                    "for an oil change."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Reinsert the dipstick back\n" +
                    "into the oil reservoir and\n" +
                    "close the hood."
        ),
        Step(
            id = 9, number = "Disclaimer", description =
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