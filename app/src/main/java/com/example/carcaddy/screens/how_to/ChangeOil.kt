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
fun ChangeOil(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "You'll need oil, a new oil filter,\n" +
                    "a drain pan, a wrench, and a funnel."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Locate the oil drain plug, remove it,\n" +
                    "and let the oil drain out."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Remove the old oil filter and\n" +
                    "replace it with a new one."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Use a funnel to refill the oil\n" +
                    "reservoir with the recommended\n" +
                    "amount of new oil."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Use the dipstick to check the oil\n" +
                    "level and ensure it's at the correct level."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Take the old oil and filter to a recycling center\n" +
                    "or auto parts store that accepts used oil."
        ),
        Step(
            id = 7, number = "Disclaimer", description =
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