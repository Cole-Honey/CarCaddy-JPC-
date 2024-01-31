package com.example.carcaddy.screens.fetch_vin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.repository.VehicleRepository
import com.example.carcaddy.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchVinViewModel @Inject constructor(
    private val repository: VehicleRepository
) : ViewModel() {

    private val _fetchResult = MutableStateFlow<Response<Vehicle>?>(null)
    val fetchResult: StateFlow<Response<Vehicle>?> = _fetchResult

    var vinSearchText = mutableStateOf("")
    var yearSearchText = mutableStateOf("")

    fun fetchVehicleByVin(vin: String) {
        if (vin.isBlank()) {
            // Handle empty VIN input
            _fetchResult.value = Response.Error("VIN cannot be empty")
            println("VIN cannot be empty")
            return
        }

        viewModelScope.launch {
            try {
                // Call the repository to fetch the vehicle
                val vehicle = repository.fetchVehicleByVin(vin)
                vehicle.collect { response ->
//                    if (response is Response.Success) {
//                        val fetchedVehicle = response.data
//                        println("Fetched Vehicle: $fetchedVehicle")
//                    }
                    _fetchResult.value = response
                }
            } catch (e: Exception) {
                _fetchResult.value = Response.Error("Failed to fetch vehicle data")
                println("Failed to fetch vehicle data")
            }
        }
    }
}


