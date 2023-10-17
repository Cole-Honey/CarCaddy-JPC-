package com.example.carcaddy.screens.fetch_vin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carcaddy.screens.fetch_vin.composables.FetchVinError
import com.example.carcaddy.screens.fetch_vin.composables.FetchVinLoading
import com.example.carcaddy.screens.fetch_vin.composables.SearchBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun FetchVinScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: FetchVinViewModel = hiltViewModel()
) {

    // Collect the result from the ViewModel
    val fetchResult by viewModel.fetchResult.collectAsState()

    // Function to handle VIN submission
    fun onVinSubmitted() {
        if (viewModel.vinSearchText.toString().isNotEmpty()) {
            viewModel.fetchVehicleByVin(viewModel.vinSearchText.toString())
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        // TextField to enter the VIN
        SearchBar(
            searchTerm = viewModel.vinSearchText,
            searchFun = {viewModel.fetchVehicleByVin(it)}
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button to submit the VIN
        Button(
            onClick = { onVinSubmitted() }
        ) {
            Text("Submit VIN")
        }

        // Display loading, success, or error based on the fetchResult
        when (fetchResult) {
            is FetchVinViewModel.FetchResult.Loading -> {
                FetchVinLoading(vin = viewModel.vinSearchText.toString())
            }

            is FetchVinViewModel.FetchResult.Success -> {
                Text("Vehicle Fetched Successfully")
//            navigator.navigate(MyGarageScreenDestination())
            }

            is FetchVinViewModel.FetchResult.Error -> {
                FetchVinError(message = (fetchResult as FetchVinViewModel.FetchResult.Error).message)
            }

            else -> {}
        }
    }
}