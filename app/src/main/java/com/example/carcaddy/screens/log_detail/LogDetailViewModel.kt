package com.example.carcaddy.screens.log_detail

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
class LogDetailViewModel @Inject constructor(
    private val repository: VehicleRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var passedLog: String =
        savedStateHandle.get<String>("logId")
            ?: throw IllegalArgumentException("Expected Log in Navigation, got nothing :: LogDetailViewModel")

    var _log = MutableStateFlow<Response<MaintenanceLog>>(Response.Loading())
    val log = _log.asStateFlow()

    init {
        getLogById(passedLog)
    }

    fun getLogById(log: String) {
        viewModelScope.launch {
            repository.getLogById(log)
                .collect { response ->
                    _log.value = response
                }
        }
    }
}