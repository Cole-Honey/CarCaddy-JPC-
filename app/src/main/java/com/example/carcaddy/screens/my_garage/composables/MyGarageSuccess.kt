package com.example.carcaddy.screens.my_garage.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.composables.VehicleDetailText

@Composable
fun MyGarageSuccess(
    vehicle: Vehicle,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    val (vin, year, make, model, mileage, image) = vehicle

    LazyColumn(
        contentPadding = innerPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
            ) {

                // Image of vehicle goes here
//                Image(
//                    painter = image,
//                    contentDescription = "Car Image",
//                    modifier = Modifier
//                        .size(50.dp)
//                        .background(Color.Transparent)
//                        .border(1.dp, Color.Black, shape = CircleShape)
//                )

                Column {
                    Text(text = "VIN")
                    VehicleDetailText(vin)
                    Text(text = "Mileage")
                    VehicleDetailText(mileage ?: "--")
                }
                Column {
                    Text(text = "Year")
                    VehicleDetailText(year ?: "--")
                    Text(text = "Make")
                    VehicleDetailText(make ?: "--")
                }
            }
        }
    }
}