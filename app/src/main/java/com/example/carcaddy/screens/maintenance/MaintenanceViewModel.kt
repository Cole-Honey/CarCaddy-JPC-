package com.example.carcaddy.screens.maintenance

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.repository.VehicleRepository
import com.example.carcaddy.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MaintenanceViewModel @Inject constructor(
    private val repository: VehicleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var passedLogs: List<Long> =
        savedStateHandle.get<List<Long>>("logId")
            ?: throw IllegalArgumentException(
                "Expected Logs in Navigation, got Nothing :: MaintenanceViewModel"
            )

    var _logs = MutableStateFlow<Response<List<MaintenanceLog>>>(Response.Loading())
    var logs = _logs.asStateFlow()

    init {
        passedLogs
    }

//    fun getAllLogs(logs: List<String>) {
//        viewModelScope.launch {
//            repository.getAllLogs(logs)
//                .collect { response ->
//                    _logs.value = response
//                    Log.d("ViewModel", "Logs data retrieved")
//                }
//        }
//    }
}