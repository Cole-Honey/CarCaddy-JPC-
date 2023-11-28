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
            "Park on level surface, start engine for accurate fluid reading."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Open hood and locate the transmission dipstick, usually labeled with a distinctive handle."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Remove the dipstick from its location, often near the engine or at the back of the engine bay."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Use a cloth or paper towel to wipe the dipstick clean of any fluid residue."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Fully reinsert the dipstick into the transmission, ensuring it is seated properly."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Pull out the dipstick again and observe the fluid level between the designated \"Full\" and \"Add\" or \"Cold\" and \"Hot\" marks on the dipstick."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Assess the fluid condition, which should be translucent and have a reddish color. A dirty, brownish, or burnt smell indicates potential issues."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "If the fluid level is below the \"Add\" or \"Cold\" mark, you'll need to add transmission fluid. Insert a funnel into the dipstick tube and pour the appropriate fluid."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Reinsert the dipstick securely, ensuring it fits properly."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Turn off the engine and wait a few minutes for the fluid to settle."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Pull out the dipstick again and recheck the fluid level to ensure it falls within the recommended range."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Confirm the dipstick is secure and close the hood of your vehicle."
        ),
        Step(
            id = 13, number = "Disclaimer", description =
            "Remember, these steps are a general guide. We recommend consulting your vehicle's specific manual or manufacturer for precise instructions."
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