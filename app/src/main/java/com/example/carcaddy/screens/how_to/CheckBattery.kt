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
fun CheckBattery(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Ensure the vehicle is parked\n" +
                    "and the engine is turned off."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Open the hood and locate the\n" +
                    "vehicle's battery."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Inspect the battery for any signs\n" +
                    "of corrosion, such as white\n" +
                    "or greenish deposits."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Check the battery cables for any\n" +
                    "loose or corroded connections."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Use a voltmeter or multimeter to\n" +
                    "measure the battery voltage."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Connect the positive (+) probe to the\n" +
                    "battery's positive terminal and the\n" +
                    "negative (-) probe to the negative terminal."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Read and record the voltage\n" +
                    "displayed on the voltmeter."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Compare the voltage reading with the\n" +
                    "manufacturer's recommended voltage range."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "If the voltage is below the recommended\n" +
                    "range, the battery may be discharged or faulty."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Check the battery's physical condition\n" +
                    "for any cracks, leaks, or swelling."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "If necessary, clean the battery\n" +
                    "terminals and cable connections\n" +
                    "using a mixture of baking soda and water."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Ensure all connections are\n" +
                    "securely tightened after cleaning."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "If the battery voltage is low or the\n" +
                    "battery shows signs of damage,\n" +
                    "consider testing or replacing it."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Close the hood of the vehicle."
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