package com.example.carcaddy.screens.my_garage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carcaddy.utils.Response
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

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
}