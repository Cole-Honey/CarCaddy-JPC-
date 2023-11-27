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
fun CheckTransmissionFluid(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park on level surface, start\n" +
                    "engine for accurate fluid reading."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Open hood and locate the\n" +
                    "transmission dipstick, usually\n" +
                    "labeled with a distinctive handle."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Remove the dipstick from its\n" +
                    "location, often near the engine\n" +
                    "or at the back of the engine bay."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Use a cloth or paper towel to wipe\n" +
                    "the dipstick clean of any fluid residue."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Fully reinsert the dipstick into the\n" +
                    "transmission, ensuring it is seated properly."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Pull out the dipstick again and observe\n" +
                    "the fluid level between the designated\n" +
                    "\"Full\" and \"Add\" or \"Cold\" and \"Hot\"\n" +
                    "marks on the dipstick."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Assess the fluid condition, which\n" +
                    "should be translucent and have a reddish\n" +
                    "color. A dirty, brownish, or burnt\n" +
                    "smell indicates potential issues."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "If the fluid level is below the \"Add\" or\n" +
                    "\"Cold\" mark, you'll need to add transmission\n" +
                    "fluid. Insert a funnel into the\n" +
                    "dipstick tube and pour the appropriate fluid."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Reinsert the dipstick securely,\n" +
                    "ensuring it fits properly."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Turn off the engine and wait a\n" +
                    "few minutes for the fluid to settle."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Pull out the dipstick again and\n" +
                    "recheck the fluid level to ensure\n" +
                    "it falls within the recommended range."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Confirm the dipstick is secure\n" +
                    "and close the hood of your vehicle."
        ),
        Step(
            id = 13, number = "Disclaimer", description =
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