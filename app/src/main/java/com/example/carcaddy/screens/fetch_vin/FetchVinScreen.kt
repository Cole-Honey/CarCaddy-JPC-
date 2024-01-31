package com.example.carcaddy.screens.fetch_vin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.carcaddy.screens.fetch_vin.composables.FetchVinError
import com.example.carcaddy.screens.fetch_vin.composables.FetchVinLoading
import com.example.carcaddy.screens.fetch_vin.composables.SearchBar
import com.example.carcaddy.screens.navigation.Directions
import com.example.carcaddy.utils.Response

@Composable
fun FetchVinScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: FetchVinViewModel = hiltViewModel()
) {

    // Collect the result from the ViewModel
    val fetchResult by viewModel.fetchResult.collectAsState()

    // Function to handle VIN submission
    fun onVinSubmitted() {
        if (viewModel.vinSearchText.toString().isNotEmpty()) {
            viewModel.fetchVehicleByVin(
                viewModel.vinSearchText.value,
            )
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        // TextField to enter the VIN
        SearchBar(
            searchTerm1 = viewModel.vinSearchText,
            searchFun = { viewModel.fetchVehicleByVin(it) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button to submit the VIN
        Button(
            onClick = { onVinSubmitted() }
        ) {
            Text(text = "Submit VIN", color = MaterialTheme.colorScheme.secondary)
        }

        // Display loading, success, or error based on the fetchResult
        when (fetchResult) {
            is Response.Loading -> {
                FetchVinLoading()
            }

            is Response.Success -> {
                navController.navigate(Directions.MyGarage.path)
            }

            is Response.Error -> {
                FetchVinError(message = (fetchResult as Response.Error).message)
            }

            else -> {}
        }
    }
}