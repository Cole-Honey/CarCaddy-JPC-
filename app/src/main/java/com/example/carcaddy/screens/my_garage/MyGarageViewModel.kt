package com.example.carcaddy.screens.my_garage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.model.VehicleWithLogs
import com.example.carcaddy.repository.VehicleRepository
import com.example.carcaddy.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyGarageViewModel @Inject constructor(
    private val repository: VehicleRepository
): ViewModel() {

    var _vehicles = MutableStateFlow<Response<List<VehicleWithLogs>>>(Response.Loading())
    val vehicles = _vehicles.asStateFlow()

    fun getVehicles() {
        viewModelScope.launch {
            repository.getVehicleWithLogs().collect {
                _vehicles.value = it
                println("Vehicles list: $_vehicles")
            }
        }
    }
}