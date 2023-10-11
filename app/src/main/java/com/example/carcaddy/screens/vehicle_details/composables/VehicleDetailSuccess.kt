package com.example.carcaddy.screens.vehicle_details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.Vehicle

@Composable
fun VehicleDetailSuccess(
    vehicle: Vehicle,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    // Destructure vehicle properties for cleaner code
    val (vin, year, make, model, mileage) = vehicle

    LazyColumn(
        contentPadding = innerPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            // Image of the vehicle goes here

            // Vehicle VIN
            VehicleDetailText(vin)

            Column {
                // Vehicle make
                VehicleDetailText(year)

                // Vehicle model
                VehicleDetailText(make)

                // Vehicle year
                VehicleDetailText(model)

                // Vehicle mileage
                VehicleDetailText(mileage)
            }

            // Image of Vehicle Insurance
            // Image of Vehicle Registration
        }
    }
}

@Composable
fun VehicleDetailText(
    text: String?,
) {
    text?.let {
        Text(text = it)
    }
}