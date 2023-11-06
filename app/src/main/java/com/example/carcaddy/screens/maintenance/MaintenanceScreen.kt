package com.example.carcaddy.screens.maintenance

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.carcaddy.screens.maintenance.composables.MaintenanceEmpty
import com.example.carcaddy.screens.maintenance.composables.MaintenanceError
import com.example.carcaddy.screens.maintenance.composables.MaintenanceSuccess
import com.example.carcaddy.screens.maintenance.composables.MaintenanceTopBar
import com.example.carcaddy.screens.my_garage.composables.MyGarageError
import com.example.carcaddy.utils.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaintenanceScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MaintenanceViewModel = hiltViewModel()
) {

    val logsState by viewModel.logs.collectAsStateWithLifecycle()

    val (logs, errorMessage) = when (logsState) {
        is Response.Success -> {
            val data = (logsState as Response.Success).data
            data to null
        }

        is Response.Error -> {
            null to "Error: ${(logsState as Response.Error).message}"
        }

        else -> {
            null to null
        }
    }

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState(), { true })

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val openBottomSheet: () -> Unit = {
        isSheetOpen = true
    }

    Scaffold(
        topBar = {
            MaintenanceTopBar(
                scrollBehavior = scrollBehavior,
                openScreen = { openBottomSheet() }
            )
        }
    ) { innerPadding ->
        if (logs != null && logs.isNotEmpty()) {
            MaintenanceSuccess(
                logs = logs,
                innerPadding = innerPadding,
                onItemClick = { selectedLog ->
                    // TODO Figure out what is to happen when the LOG is clicked
                }
            )

            // TODO Open up a bottom shee to add logs

        } else if (errorMessage != null) {
            MaintenanceError(message = errorMessage)
            println("Error loading logs: $errorMessage")
        } else {
            MaintenanceEmpty()
        }
    }
}