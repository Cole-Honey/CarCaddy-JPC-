package com.example.carcaddy.screens.vehicle_details.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.composables.CustomText
import com.example.carcaddy.screens.composables.DocumentImage
import com.example.carcaddy.screens.composables.RoundImage
import com.example.carcaddy.screens.composables.VehicleDetailText

@Composable
fun VehicleDetailSuccess(
    vehicle: Vehicle?,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 16.dp)
            .background(MaterialTheme.colorScheme.tertiary)
    ) {

        item {
            if (vehicle != null) {
                vehicle.image?.let {
                    RoundImage(
                        image = it,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = CircleShape)
                    )
                }
            } else {
                println("The vehicle image is null")
            }
        }

        item {
            // Vehicle VIN
            VehicleDetailText(vehicle?.vin)
        }

        // Push up VehicleInformationColumn to the left side
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                VehicleInformation(vehicle = vehicle)
            }
        }

        item {
            // Image of Vehicle Insurance
            // Image of Vehicle Registration
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                CustomText(text = "Insurance:")
                if (vehicle != null) {
                    vehicle.insuranceImage?.let {
                        DocumentImage(
                            image = it,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                        )
                    }
                }

                CustomText(text = "Registration:")
                if (vehicle != null) {
                    vehicle.registrationImage?.let {
                        DocumentImage(
                            image = it,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}