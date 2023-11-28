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
fun ChangeBattery(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Ensure the vehicle is parked and the engine is turned off."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Open the hood and locate the vehicle's battery."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Disconnect the negative (-) battery cable by loosening the terminal clamp nut and removing it."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Disconnect the positive (+) battery cable using the same method."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Remove any additional clamps or brackets securing the battery in place."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Lift the old battery out of its tray and set it aside."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Clean the battery tray and terminal connections with a mixture of baking soda and water if needed."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Place the new battery into the tray, ensuring it is properly aligned."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Connect the positive (+) battery cable to the corresponding terminal and tighten the clamp nut."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Connect the negative (-) battery cable to the corresponding terminal and tighten the clamp nut."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Double-check all connections to ensure they are secure."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Clean any corrosion from the battery terminals and apply a thin coat of petroleum jelly for protection."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Close the hood of the vehicle."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Properly dispose of the old battery at a recycling center or authorized facility."
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
                youtubeVideoId = "YC--MLNIbik",
                lifecycleOwner = LocalLifecycleOwner.current
            )
        }
    }
}