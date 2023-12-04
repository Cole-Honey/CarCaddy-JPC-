package com.example.carcaddy.screens.log_detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carcaddy.screens.log_detail.composables.LogDetailError
import com.example.carcaddy.screens.log_detail.composables.LogDetailLoading
import com.example.carcaddy.screens.log_detail.composables.LogDetailSuccess
import com.example.carcaddy.utils.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogDetailScreen(
    log: String,
    modifier: Modifier = Modifier,
    viewModel: LogDetailViewModel = hiltViewModel()
) {

    val logState by viewModel.log.collectAsStateWithLifecycle()

    val (log, errorMessage) = when (logState) {
        is Response.Success -> {
            val data = (logState as Response.Success).data
            data to null
        }

        is Response.Error -> {
            null to "Error: ${(logState as Response.Error).message}"
        }

        else -> {
            null to null
        }
    }

    Scaffold { innerPadding ->
        when (val state = logState) {
            is Response.Loading -> {
                LogDetailLoading()
            }

            is Response.Success -> {
                LogDetailSuccess(
                    log = state.data,
                    innerPadding = innerPadding
                )
            }

            is Response.Error -> {
                LogDetailError(message = errorMessage)
            }
        }
    }

}