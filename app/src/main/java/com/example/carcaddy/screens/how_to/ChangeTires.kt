package com.example.carcaddy.screens.how_to

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.example.carcaddy.screens.how_to.composables.steps.Step
import com.example.carcaddy.screens.how_to.composables.steps.StepComponent
import com.example.carcaddy.screens.how_to.composables.youtube_player.YoutubePlayer

@Composable
fun ChangeTires(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the vehicle on a flat surface and engage the parking brake."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Locate the spare tire, jack, and lug wrench in your vehicle."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Loosen the lug nuts on the flat tire using the lug wrench but don't remove them yet."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Position the jack under the vehicle in the designated lifting point."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Use the jack to raise the vehicle until the flat tire is off the ground."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Fully remove the lug nuts and take off the flat tire."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Place the spare tire onto the wheel hub, aligning the lug nut holes."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Hand-tighten the lug nuts in a star pattern."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Lower the vehicle with the jack and remove the jack from underneath."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Use the lug wrench to tighten the lug nuts firmly in a star pattern."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Double-check that all lug nuts are tightened properly."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Store the flat tire, jack, and lug wrench in the vehicle."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Regularly check the tire pressure of all tires, including the spare, for proper inflation."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Repair or replace the flat tire as soon as possible!"
        ),
        Step(
            id = 15, number = "Disclaimer", description =
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

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(text = "Video Help")

            YoutubePlayer(
                youtubeVideoId = "314HE4aMG-g",
                lifecycleOwner = LocalLifecycleOwner.current
            )
        }
    }
}