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
fun CheckTires(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park the vehicle on a level surface\n" +
                    "and engage the parking brake."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Inspect each tire for any visible\n" +
                    "signs of damage, such as cuts,\n" +
                    "bulges, or uneven wear."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Use a tire pressure gauge to check\n" +
                    "the air pressure in each tire."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Compare the measured pressure with\n" +
                    "the recommended pressure listed\n" +
                    "in the vehicle's manual or placard."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Adjust tire pressure if necessary,\n" +
                    "using an air compressor or\n" +
                    "adding/removing air as needed."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Examine the tire tread depth by\n" +
                    "placing a penny upside down\n" +
                    "into the tread grooves."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "If Lincoln's head is fully visible,\n" +
                    "the tire tread may be too\n" +
                    "worn and should be replaced."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Ensure all tires have consistent\n" +
                    "tread wear across the width and\n" +
                    "circumference of the tire."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Look for any foreign objects,\n" +
                    "such as nails or stones,\n" +
                    "embedded in the tire treads."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Check the sidewalls for any cracks,\n" +
                    "bulges, or signs of damage."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Verify that the wheel lug nutsare\n" +
                    "properly tightened using a lug wrench."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "If your vehicle has a spare tire,\n" +
                    "ensure it is in good condition\n" +
                    "and properly inflated."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Repeat the tire inspection regularly,\n" +
                    "including the spare tire, to maintain\n" +
                    "optimal tire condition."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Consult your vehicle's manual for\n" +
                    "specific tire pressure recommendations\n" +
                    "and other manufacturer guidelines."
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