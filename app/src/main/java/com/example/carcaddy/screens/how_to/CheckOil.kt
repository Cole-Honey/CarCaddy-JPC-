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
fun CheckOil(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the car on level ground."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Locate the dipstick and remove it."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Wipe the dipstick clean"
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Reinsert the dipstick fully back into the oil reservoir."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Remove the dipstick again and check the oil level against the minimum and maximum markings."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Check the oil color and consistency."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "If the oil level is low, top it off. If the oil is dirty, it may be time for an oil change."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Reinsert the dipstick back into the oil reservoir and close the hood."
        ),
        Step(
            id = 9, number = "Disclaimer", description =
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
                youtubeVideoId = "zmwLj1pnreg",
                lifecycleOwner = LocalLifecycleOwner.current
            )
        }
    }
}