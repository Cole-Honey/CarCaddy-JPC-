package com.example.carcaddy.screens.vehicle_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.repository.VehicleRepository
import com.example.carcaddy.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleDetailsViewModel @Inject constructor(
    private val repository: VehicleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    var passedVehicle: String =
        savedStateHandle.get<String>("vin")
            ?: throw IllegalArgumentException("Expected Vehicle in Navigation, got nothing")

    var _vehicle = MutableStateFlow<Response<Vehicle>>(Response.Loading())
    val vehicle = _vehicle.asStateFlow()

    init {
        getVehicleById(passedVehicle)
    }

    fun getVehicleById(vin: String) {
        viewModelScope.launch {
            repository.getVehicleFromDatabaseByVin(vin)
                .collect {
                _vehicle.value = it
            }
        }
    }
}