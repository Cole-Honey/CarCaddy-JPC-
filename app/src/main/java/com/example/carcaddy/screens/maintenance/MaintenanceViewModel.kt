package com.example.carcaddy.screens.maintenance

import android.util.Log
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
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MaintenanceViewModel @Inject constructor(
    private val repository: VehicleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val logIdsString: String? = savedStateHandle.get("logIds")
    val passedLogs: List<Long> = if (!logIdsString.isNullOrBlank()) {
        Gson().fromJson(logIdsString, object : TypeToken<List<Long>>() {}.type)
    } else {
        emptyList()
    }


    var _logs = MutableStateFlow<Response<List<MaintenanceLog>>>(Response.Loading())
    var logs = _logs.asStateFlow()

    var selectedLog: MaintenanceLog? = null

//    init {
//        getAllLogs(passedLogs)
//        Log.d("Navigation", "Logs Passed: $passedLogs")
//    }

    fun onLogClicked(log: MaintenanceLog) {
        selectedLog = log
    }

    fun getAllLogs(logs: List<Long>) {
        viewModelScope.launch {
            repository.getAllLogs(logs)
                .collect { response ->
                    _logs.value = response
                    Log.d("ViewModel", "Logs data retrieved")
                }
        }
    }

    // Inside your ViewModel
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
                vin = vin
            )
            repository.addLog(newLog)
            Log.d("ViewModel", "Log added: $log")
        }
    }
}