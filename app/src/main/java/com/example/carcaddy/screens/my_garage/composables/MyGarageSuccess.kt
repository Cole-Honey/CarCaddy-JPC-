package com.example.carcaddy.screens.my_garage.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.composables.VehicleDetailText
import com.example.carcaddy.utils.VehicleTestData

@Composable
fun MyGarageSuccess(
    vehicles: List<Vehicle>,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    val testVehicles = listOf(VehicleTestData.vehicleTestData1, VehicleTestData.vehicleTestData2)

    LazyColumn(
        contentPadding = innerPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        items(vehicles) { vehicle ->
            GarageListItem(vehicle = vehicle)
        }
    }
}
