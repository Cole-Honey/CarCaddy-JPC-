package com.example.carcaddy.screens.vehicle_details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.composables.CustomText
import com.example.carcaddy.screens.composables.VehicleDetailText

@Composable
fun VehicleInformation(
    vehicle: Vehicle?,
    modifier: Modifier = Modifier
) {

    val spaceBetween = 3.dp

    Box {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.padding(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(text = "Year:")
                Spacer(modifier = Modifier.padding(horizontal = spaceBetween))
                VehicleDetailText(vehicle?.year)
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(text = "Make:")
                Spacer(modifier = Modifier.padding(horizontal = spaceBetween))
                VehicleDetailText(vehicle?.make)
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(text = "Model:")
                Spacer(modifier = Modifier.padding(horizontal = spaceBetween))
                VehicleDetailText(vehicle?.model)
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(text = "Mileage:")
                Spacer(modifier = Modifier.padding(horizontal = spaceBetween))
                VehicleDetailText(vehicle?.mileage ?: "--NA--")
            }

            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}