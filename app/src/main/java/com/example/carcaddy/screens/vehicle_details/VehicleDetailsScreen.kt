package com.example.carcaddy.screens.vehicle_details

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailError
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailLoading
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailSuccess
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailsTopBar
import com.example.carcaddy.utils.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleDetailsScreen(
    vehicle: Vehicle,
    modifier: Modifier = Modifier,
    vehicleDetailsVM: VehicleDetailsViewModel = hiltViewModel()
) {

    val vehicleVM by vehicleDetailsVM.vehicle.collectAsStateWithLifecycle()

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

        when (val state = vehicleVM) {
            is Response.Loading -> {
                vehicle.name?.let { VehicleDetailLoading(name = it) }
            }

            is Response.Success -> {
                VehicleDetailSuccess(
                    vehicle = state.data,
                    innerPadding = innerPadding
                )

//                EditPopup(
//                    vehicle = state.data,
//                    openEditScreen = { /*TODO*/ },
//                    modifier = modifier
//                )
            }

            is Response.Error -> {
                VehicleDetailError(message = "Error: ${state.message}")
            }
        }
    }
}