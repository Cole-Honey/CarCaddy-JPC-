package com.example.carcaddy.screens.vehicle_details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            // Image of the vehicle goes here

            // Vehicle VIN
            VehicleDetailText(vehicle?.vin)

            Column {
                // Vehicle make
                VehicleDetailText(vehicle?.year)

                // Vehicle model
                VehicleDetailText(vehicle?.make)

                // Vehicle year
                VehicleDetailText(vehicle?.model)

                // Vehicle mileage
                VehicleDetailText(vehicle?.mileage)
            }

            // Image of Vehicle Insurance
            // Image of Vehicle Registration
        }
    }
}

