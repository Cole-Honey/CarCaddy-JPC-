package com.example.carcaddy.screens.maintenance

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.repository.VehicleRepository
import com.example.carcaddy.utils.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MaintenanceViewModel @Inject constructor(
    private val repository: VehicleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var _logs = MutableStateFlow<Response<List<MaintenanceLog>>>(Response.Loading())
    var logs = _logs.asStateFlow()

    var selectedLog: MaintenanceLog? = null

    fun onLogClicked(log: MaintenanceLog) {
        selectedLog = log
    }

    fun getAllLogs(vin: String) {
        viewModelScope.launch {
            repository.getAllLogs(vin)
                .collect { response ->
                    _logs.value = response
                }
        }
    }

    fun addLog(
        vin: String,
        log: MaintenanceLog
    ) {
        viewModelScope.launch {
            val newLog = MaintenanceLog(
                maintenanceType = log.maintenanceType,
                date = log.date,
                cost = log.cost,
                description = log.description,
                image = log.image,
                vin = vin
            )
            repository.addLog(newLog)

            val updatedLogs = repository.getAllLogs(vin)
            updatedLogs.collect {
                _logs.value = it
            }
        }
    }

    fun deleteLog(log: MaintenanceLog) {
        viewModelScope.launch {
            repository.deleteLog(log)
        }
    }
}