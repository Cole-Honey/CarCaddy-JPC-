package com.example.carcaddy.screens.my_garage.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.VehicleWithLogs
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MyGarageSuccess(
    vehicles: List<VehicleWithLogs>?,
    innerPadding: PaddingValues,
    onItemClick: (VehicleWithLogs) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = innerPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        vehicles?.let { vehicleList ->
            items(vehicleList) { vehicle ->
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    GarageListItem(vehicle = vehicle, onItemClick = { onItemClick(vehicle) })
                }
                Divider(
                    color = Color.Black,
                    thickness = 1.dp
                )
            }
        }
    }
}