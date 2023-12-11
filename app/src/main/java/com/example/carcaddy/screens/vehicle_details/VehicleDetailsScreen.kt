package com.example.carcaddy.screens.vehicle_details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.carcaddy.screens.topbar_interactions.garage.InteractionsPopupScreen
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailError
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailLoading
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailSuccess
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailsTopBar
import com.example.carcaddy.utils.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleDetailsScreen(
    navController: NavController,
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

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val openBottomSheet: () -> Unit = {
        isSheetOpen = true
    }

    Scaffold(
        topBar = {
            VehicleDetailsTopBar(
                name = vehicle?.name ?: vehicle?.model ?: "--",
                scrollBehavior = scrollBehavior,
                openScreen = { openBottomSheet() },
                navController = navController,
                modifier = modifier
            )
        },
        modifier = modifier
            .background(MaterialTheme.colorScheme.tertiary)
    ) { innerPadding ->

        when (val state = vehicleState) {
            is Response.Loading -> {
                VehicleDetailLoading()
            }

            is Response.Success -> {
                VehicleDetailSuccess(
                    vehicle = state.data,
                    innerPadding = innerPadding
                )

                InteractionsPopupScreen(
                    vehicle = state.data,
                    onSave = { vehicle ->
                        viewModel.updateVehicle(vehicle)
                        viewModel.getVehicleById(vehicle.vin)
                    },
                    isSheetOpen = isSheetOpen,
                    onCloseSheet = { isSheetOpen = false }
                )
            }

            is Response.Error -> {
                VehicleDetailError(message = errorMessage)
            }
        }
    }
}
