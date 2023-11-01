package com.example.carcaddy.screens.vehicle_details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.Vehicle
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
    ) {
        item {
            // Image of the vehicle goes here
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
        }
    }
}


