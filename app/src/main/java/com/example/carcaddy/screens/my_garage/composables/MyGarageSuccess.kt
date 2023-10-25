package com.example.carcaddy.screens.my_garage.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.VehicleWithLogs

@Composable
fun MyGarageSuccess(
    vehicles: List<VehicleWithLogs>?,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        contentPadding = innerPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        vehicles?.let { vehicleList ->
            items(vehicleList) { vehicle ->
                GarageListItem(vehicle = vehicle)
            }
        }
    }
}