package com.example.carcaddy.screens.fetch_vin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.repository.VehicleRepository
import com.example.carcaddy.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchVinViewModel @Inject constructor(
    private val repository: VehicleRepository
) : ViewModel() {

    // Define a sealed class to represent the fetch result
    sealed class FetchResult {
        data class Success(val vehicle: Flow<Response<Vehicle>>) : FetchResult()
        data class Error(val message: String) : FetchResult()
        data class Loading(val message: String) : FetchResult()
    }

    // Use StateFlow to handle the fetch result
    private val _fetchResult = MutableStateFlow<FetchResult?>(null)
    val fetchResult: StateFlow<FetchResult?> = _fetchResult

    var vinSearchText = mutableStateOf("")

    fun fetchVehicleByVin(vin: String) {
        if (vin.isBlank()) {
            // Handle empty VIN input
            _fetchResult.value = FetchResult.Error("VIN cannot be empty")
            return
        }

        viewModelScope.launch {
            try {
                // Call the repository to fetch the vehicle
                val vehicle = repository.fetchVehicleByVin(vin)
                _fetchResult.value = FetchResult.Success(vehicle)
            } catch (e: Exception) {
                // Handle errors
                _fetchResult.value = FetchResult.Error("Failed to fetch vehicle data")
            }
        }
    }
}
