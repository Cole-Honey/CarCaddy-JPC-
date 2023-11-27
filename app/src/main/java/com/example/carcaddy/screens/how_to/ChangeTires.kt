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
fun ChangeTires(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the vehicle on a flat surface\n" +
                    "and engage the parking brake."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Locate the spare tire, jack,\n" +
                    "and lug wrench in your vehicle."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Loosen the lug nuts on the flat\n" +
                    "tire using the lug wrench but\n" +
                    "don't remove them yet."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Position the jack under the vehicle\n" +
                    "in the designated lifting point."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Use the jack to raise the vehicle\n" +
                    "until the flat tire is off the ground."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Fully remove the lug nuts and\n" +
                    "take off the flat tire."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Place the spare tire onto the\n" +
                    "wheel hub, aligning the lug nut holes."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Hand-tighten the lug nuts\n" +
                    "in a star pattern."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Lower the vehicle with the jack\n" +
                    "and remove the jack from underneath."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Use the lug wrench to tighten the\n" +
                    "lug nuts firmly in a star pattern."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Double-check that all lug\n" +
                    "nuts are tightened properly."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Store the flat tire, jack, and\n" +
                    "lug wrench in the vehicle."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Regularly check the tire pressure\n" +
                    "of all tires, including the spare,\n" +
                    "for proper inflation."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Repair or replace the flat tire\n" +
                    "as soon as possible!"
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