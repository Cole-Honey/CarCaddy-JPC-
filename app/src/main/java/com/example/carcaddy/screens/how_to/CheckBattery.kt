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
fun CheckBattery(
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
            "Inspect the battery for any signs of corrosion, such as white or greenish deposits."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Check the battery cables for any loose or corroded connections."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Use a voltmeter or multimeter to measure the battery voltage."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Connect the positive (+) probe to the battery's positive terminal and the negative (-) probe to the negative terminal."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Read and record the voltage displayed on the voltmeter."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Compare the voltage reading with the manufacturer's recommended voltage range."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "If the voltage is below the recommended range, the battery may be discharged or faulty."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Check the battery's physical condition for any cracks, leaks, or swelling."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "If necessary, clean the battery terminals and cable connections using a mixture of baking soda and water."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Ensure all connections are securely tightened after cleaning."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "If the battery voltage is low or the battery shows signs of damage, consider testing or replacing it."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Close the hood of the vehicle."
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