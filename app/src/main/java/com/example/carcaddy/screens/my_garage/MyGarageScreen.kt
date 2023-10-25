package com.example.carcaddy.screens.my_garage

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carcaddy.screens.my_garage.composables.MyGarageError
import com.example.carcaddy.screens.my_garage.composables.MyGarageLoading
import com.example.carcaddy.screens.my_garage.composables.MyGarageSuccess
import com.example.carcaddy.screens.vehicle_details.composables.VehicleDetailsTopBar
import com.example.carcaddy.utils.Response
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun MyGarageScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: MyGarageViewModel = hiltViewModel()
) {
    val vehiclesState by viewModel.vehicles.collectAsStateWithLifecycle()

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
            VehicleDetailsTopBar(
                name = "My Garage",
                scrollBehavior = scrollBehavior,
                openEditScreen = { /*TODO*/ },
                modifier = modifier
            )
        }
    ) { innerPadding ->
        if (vehicle != null) {
            MyGarageSuccess(
                vehicles = vehicle,
                innerPadding = innerPadding,
            )
            println("Successfully loaded vehicles")
        } else if (errorMessage != null) {
            MyGarageError(message = errorMessage)
            println("Error loading vehicles")
        } else {
            MyGarageLoading(name = "Loading...")
        }
    }
}


