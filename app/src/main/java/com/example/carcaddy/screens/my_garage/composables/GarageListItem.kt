package com.example.carcaddy.screens.my_garage.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.composables.VehicleDetailText

@Composable
fun GarageListItem(vehicle: Vehicle) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
    ) {

        // Image of vehicle goes here

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Year",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.year ?: "--")
            Text(
                text = "Mileage",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.mileage ?: "--")
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Make",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.make ?: "--")
            Text(
                text = "Model",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.model ?: "--")
        }
    }
}