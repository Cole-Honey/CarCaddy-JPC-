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
fun ChangeBattery(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Ensure the vehicle is parked and\n" +
                    "the engine is turned off."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Open the hood and locate the\n" +
                    "vehicle's battery."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Disconnect the negative (-) battery\n" +
                    "cable by loosening the terminal\n" +
                    "clamp nut and removing it."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Disconnect the positive (+)\n" +
                    "battery cable using the same method."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Remove any additional clamps or\n" +
                    "brackets securing the battery in place."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Lift the old battery out of its\n" +
                    "tray and set it aside."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Clean the battery tray and terminal\n" +
                    "connections with a mixture of\n" +
                    "baking soda and water if needed."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Place the new battery into the tray,\n" +
                    "ensuring it is properly aligned."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Connect the positive (+) battery\n" +
                    "cable to the corresponding terminal\n" +
                    "and tighten the clamp nut."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Connect the negative (-) battery\n" +
                    "cable to the corresponding terminal\n" +
                    "and tighten the clamp nut."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Double-check all connections to\n" +
                    "ensure they are secure."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Clean any corrosion from the battery\n" +
                    "terminals and apply a thin coat of\n" +
                    "petroleum jelly for protection."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Close the hood of the vehicle."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Properly dispose of the old battery\n" +
                    "at a recycling center or authorized facility."
        ),
        Step(
            id = 15, number = "Disclaimer", description =
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