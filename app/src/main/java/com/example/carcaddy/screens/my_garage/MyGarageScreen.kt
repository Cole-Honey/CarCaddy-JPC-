package com.example.carcaddy.screens.my_garage

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.carcaddy.screens.my_garage.composables.MyGarageEmpty
import com.example.carcaddy.screens.my_garage.composables.MyGarageError
import com.example.carcaddy.screens.my_garage.composables.MyGarageSuccess
import com.example.carcaddy.screens.my_garage.composables.MyGarageTopBar
import com.example.carcaddy.screens.navigation.Directions
import com.example.carcaddy.utils.Response
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyGarageScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MyGarageViewModel = hiltViewModel()
) {
    val vehiclesState by viewModel.vehicles.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getVehicles()
    }

    val (vehicle, errorMessage) = when (vehiclesState) {
        is Response.Success -> {
            val data = (vehiclesState as Response.Success).data
            data to null
        }

        is Response.Error -> {
            null to "Error: ${(vehiclesState as Response.Error).message}"
        }

        else -> {
            null to null
        }
    }

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState(), { true })

    Scaffold(
        topBar = {
            MyGarageTopBar(
                name = "My Garage",
                scrollBehavior = scrollBehavior,
                openScreen = { navController.navigate(Directions.FetchVin.path) }, // Use a Composable lambda
                modifier = modifier
            )
        }
    ) { innerPadding ->
        if ((vehicle != null) && vehicle.isNotEmpty()) {
            MyGarageSuccess(
                vehicles = vehicle,
                innerPadding = innerPadding,
                onItemClick = { selectedVehicle ->
                    val vin = selectedVehicle.vehicle.vin

                    navController.navigate(
                        Directions.TabBar.path + "/$vin"
                    )
                    Log.d("Navigation", "The Passed VIN Was: $vin")
                },
                onItemDelete = { selectedVehicle ->
                    viewModel.deleteVehicle(selectedVehicle.vehicle)
                    viewModel.getVehicles()
                },
            )
            println("Successfully loaded vehicles")
        } else if (errorMessage != null) {
            MyGarageError(message = errorMessage)
            println("Error loading vehicles: $errorMessage")
        } else {
            MyGarageEmpty() // Display a component for an empty garage
        }
    }
}