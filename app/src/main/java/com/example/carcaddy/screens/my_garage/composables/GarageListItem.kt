package com.example.carcaddy.screens.my_garage.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.carcaddy.model.VehicleWithLogs
import com.example.carcaddy.screens.composables.VehicleDetailText

@Composable
fun GarageListItem(
    vehicle: VehicleWithLogs,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.clickable { onItemClick() }
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
            VehicleDetailText(vehicle.vehicle.year ?: "--") // Access vehicle property
            Text(
                text = "Mileage",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.vehicle.mileage ?: "--") // Access vehicle property
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Make",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.vehicle.make ?: "--") // Access vehicle property
            Text(
                text = "Model",
                fontSize = 15.sp,
                color = Color.Gray
            )
            VehicleDetailText(vehicle.vehicle.model ?: "--") // Access vehicle property
        }

        Icon(
            modifier = Modifier.weight(0.15f),
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "Arrow to show item can be clicked",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}
