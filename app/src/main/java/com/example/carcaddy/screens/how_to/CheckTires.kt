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
fun CheckTires(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the vehicle on a level surface and engage the parking brake."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Inspect each tire for any visible signs of damage, such as cuts, bulges, or uneven wear."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Use a tire pressure gauge to check the air pressure in each tire."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Compare the measured pressure with the recommended pressure listed in the vehicle's manual or placard."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Adjust tire pressure if necessary, using an air compressor or adding/removing air as needed."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Examine the tire tread depth by placing a penny upside down into the tread grooves."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "If Lincoln's head is fully visible, the tire tread may be too worn and should be replaced."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Ensure all tires have consistent tread wear across the width and circumference of the tire."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Look for any foreign objects, such as nails or stones, embedded in the tire treads."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Check the sidewalls for any cracks, bulges, or signs of damage."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Verify that the wheel lug nutsare properly tightened using a lug wrench."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "If your vehicle has a spare tire, ensure it is in good condition and properly inflated."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Repeat the tire inspection regularly, including the spare tire, to maintain optimal tire condition."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Consult your vehicle's manual for specific tire pressure recommendations and other manufacturer guidelines."
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
                youtubeVideoId = "Xv9WVOVDqm0",
                lifecycleOwner = LocalLifecycleOwner.current
            )
        }
    }
}