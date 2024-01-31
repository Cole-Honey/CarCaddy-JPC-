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
fun ChangeTransmissionFluid(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the vehicle on a level surface and engage the parking brake."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Locate the transmission fluid pan and remove the bolts to drain the fluid."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Clean the pan and replace the filter, if applicable."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Reinstall the pan, tightening the bolts to the manufacturer's specifications."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Locate the transmission fluid fill/dipstick tube."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Use a funnel to add the appropriate transmission fluid slowly into the fill/dipstick tube."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Check the fluid level using the dipstick. Add more fluid if necessary."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Start the engine, let it run, and shift through all gears."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Recheck the fluid level with the dipstick and adjust if needed."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Once the fluid level is correct, securely reinstall the dipstick."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Clean up any spills and dispose of the old transmission fluid properly."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Take the vehicle for a short drive to ensure proper transmission operation."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Periodically check for any leaks or abnormalities in transmission performance."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Refer to the vehicle's manual for specific instructions and recommendations regarding transmission fluid type and capacity."
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
                youtubeVideoId = "yb_1wbiPz9g",
                lifecycleOwner = LocalLifecycleOwner.current
            )
        }
    }
}