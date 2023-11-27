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
fun ChangeBrakes(
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        Step(
            id = 1, number = "Step 1", description =
            "Park your vehicle on a\n" +
                    "flat surface and engage\n" +
                    "the parking braketo ensure stability."
        ),
        Step(
            id = 2, number = "Step 2", description =
            "Loosen the lug nuts on the wheel using a\n" +
                    "lug wrench, but don't remove them yet."
        ),
        Step(
            id = 3, number = "Step 3", description =
            "Lift the vehicle using a jack and secure it\n" +
                    "with jack stands for safety."
        ),
        Step(
            id = 4, number = "Step 4", description =
            "Fully remove the lug nuts and take off the\n" +
                    "wheel to access the brake assembly."
        ),
        Step(
            id = 5, number = "Step 5", description =
            "Locate the caliper assembly\n" +
                    "and remove the caliper guide\n" +
                    "pins or bolts using a suitable wrench."
        ),
        Step(
            id = 6, number = "Step 6", description =
            "Carefully lift the caliper off the brake\n" +
                    "rotor and suspend it using a wire or bungee\n" +
                    "cord to avoid strain on the brake line."
        ),
        Step(
            id = 7, number = "Step 7", description =
            "Remove the old brake pads from the caliper,\n" +
                    "paying attention to their positioning and\n" +
                    "any retaining clips or hardware."
        ),
        Step(
            id = 8, number = "Step 8", description =
            "Inspect the brake rotor for wear, scoring,\n" +
                    "or damage. Replace it if necessary, following\n" +
                    "the manufacturer's instructions."
        ),
        Step(
            id = 9, number = "Step 9", description =
            "Clean the caliper and caliper bracket using\n" +
                    "brake cleaner and a brush to remove any dirt,\n" +
                    "rust, or debris."
        ),
        Step(
            id = 10, number = "Step 10", description =
            "Apply a thin layer of high-temperature brake\n" +
                    "grease or anti-seize compound to the caliper\n" +
                    "guide pins or bolts."
        ),
        Step(
            id = 11, number = "Step 11", description =
            "Install the new brake pads into the caliper,\n" +
                    "ensuring proper alignment and any required\n" +
                    "retaining clips or hardware."
        ),
        Step(
            id = 12, number = "Step 12", description =
            "Carefully compress the caliper piston\n" +
                    "using a brake caliper piston tool\n" +
                    "or a C-clamp, making sure not to\n" +
                    "damage the piston or brake line."
        ),
        Step(
            id = 13, number = "Step 13", description =
            "Reattach the caliper to the caliper bracket\n" +
                    "and tighten the guide pins or bolts to the\n" +
                    "manufacturer's specifications."
        ),
        Step(
            id = 14, number = "Step 14", description =
            "Put the wheel back onto the vehicle and\n" +
                    "hand-tighten the lug nuts in a star pattern."
        ),
        Step(
            id = 15, number = "Step 15", description =
            "Lower the vehicle, then use a torque wrench\n" +
                    "to properly tighten the lug nuts to the\n" +
                    "recommended torque specification."
        ),
        Step(
            id = 16, number = "Disclaimer", description =
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