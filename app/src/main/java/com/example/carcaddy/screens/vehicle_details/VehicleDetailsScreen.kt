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
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailError
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailLoading
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailSuccess
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailsTopBar
import com.example.carcaddy.utils.Response
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun VehicleDetailsScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: VehicleDetailsViewModel = hiltViewModel()
) {

    // Use collectAsStateWithLifecycle to observe changes in the vehicle property
    val vehicleState by viewModel.vehicle.collectAsStateWithLifecycle()

    // De-structure the state to access the data or error message
    val (vehicle, errorMessage) = when (vehicleState) {
        is Response.Success -> {
            val data = (vehicleState as Response.Success).data
            data to null
        }

        is Response.Error -> {
            null to "Error: ${(vehicleState as Response.Error).message}"
        }

        else -> {
            null to null
        }
    }

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState(), { true })

    Scaffold(
        topBar = {
            VehicleDetailsTopBar(
                name = vehicle?.name ?: "Loading...", // Show "Loading..." while loading
                scrollBehavior = scrollBehavior,
                openEditScreen = { /*TODO*/ },
                modifier = modifier
            )
        },
    ) { innerPadding ->

        if (vehicle != null) {
            VehicleDetailSuccess(
                vehicle = vehicle,
                innerPadding = innerPadding
            )

            // You can add an Edit button here when the data is loaded
        } else if (errorMessage != null) {
            VehicleDetailError(message = errorMessage)
        } else {
            VehicleDetailLoading(name = "Loading...") // Handle the loading state
        }
    }
}
