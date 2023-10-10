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
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class VehicleDetailsViewModel @Inject constructor(
    private val repository: VehicleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    var passedVehicle: Vehicle =
        savedStateHandle.get<String>("vehicle")?.let { Json.decodeFromString(it) }
            ?: throw IllegalArgumentException("Expected Vehicle in Navigation, got nothing")

    var _vehicle = MutableStateFlow<Response<Vehicle>>(Response.Loading())
    val vehicle = _vehicle.asStateFlow()

    init {
        getVehicleById(passedVehicle)
    }

    fun getVehicleById(vehicle: Vehicle) {
        viewModelScope.launch {
            repository.getVehicleByVin(vehicle)
                .collect {
                _vehicle.value = it
            }
        }
    }
}