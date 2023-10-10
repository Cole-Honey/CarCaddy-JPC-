package com.example.carcaddy.screens.vehicle_details

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailsTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleDetailsScreen(
    vehicle: Vehicle,
    modifier: Modifier = Modifier
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState(), { true })

    Scaffold(
        topBar = {
            vehicle.name?.let {
                VehicleDetailsTopBar(
                    name = it,
                    scrollBehavior = scrollBehavior,
                    openEditScreen = { /*TODO*/ },
                    modifier = modifier
                )
            }
        },
    ) { innerPadding ->

    }

}