package com.example.carcaddy.screens.maintenance

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.carcaddy.screens.add_log_screen.AddLogScreen
import com.example.carcaddy.screens.maintenance.composables.MaintenanceEmpty
import com.example.carcaddy.screens.maintenance.composables.MaintenanceError
import com.example.carcaddy.screens.maintenance.composables.MaintenanceLoading
import com.example.carcaddy.screens.maintenance.composables.MaintenanceSuccess
import com.example.carcaddy.screens.maintenance.composables.MaintenanceTopBar
import com.example.carcaddy.screens.topbar_interactions.maintenance.PopupScreen
import com.example.carcaddy.screens.topbar_interactions.maintenance_drawer.DrawerContent
import com.example.carcaddy.utils.Response
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaintenanceScreen(
    vin: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MaintenanceViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getAllLogs(vin)
    }

    val logsState by viewModel.logs.collectAsStateWithLifecycle()

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState(), { true })

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val openBottomSheet: () -> Unit = {
        isSheetOpen = true
    }

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

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

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MaintenanceTopBar(
                scrollBehavior = scrollBehavior,
                openScreen = { openBottomSheet() },
                openDrawer = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent(
                navController = navController,
                onItemClick = {

                }
            )
        },
    ) { innerPadding ->

        if ((logs != null) && logs.isNotEmpty()) {
            MaintenanceSuccess(
                logs = logs,
                innerPadding = innerPadding,
                onItemClick = { log ->
                              viewModel.onLogClicked(log)
                },
                onItemDelete = { log ->
                    viewModel.deleteLog(log)
                    viewModel.getAllLogs(vin)
                }
            )

            PopupScreen(
                onSave = {
                    viewModel.addLog(vin, it)
                    isSheetOpen = false
                },
                isSheetOpen = isSheetOpen,
                onCloseSheet = { isSheetOpen = false }
            )

        } else if (errorMessage != null) {
            MaintenanceError(message = errorMessage)
            println("Error Loading Logs: $errorMessage")
        } else {
            MaintenanceEmpty()
        }

//        when (val state = logsState) {
//            is Response.Loading -> {
//                MaintenanceLoading()
//            }
//
//            is Response.Success -> {
//                    MaintenanceSuccess(
//                        logs = state.data,
//                        innerPadding = innerPadding,
//                        onItemClick = { log ->
//                            viewModel.onLogClicked(log)
//                        },
//                        onItemDelete = { log ->
//                            viewModel.deleteLog(log)
//                            viewModel.getAllLogs(vin)
//                        },
//                    )
//
//                    PopupScreen(
//                        onSave = {
//                            viewModel.addLog(vin, it)
//                            isSheetOpen = false
//                        },
//                        isSheetOpen = isSheetOpen,
//                        onCloseSheet = { isSheetOpen = false }
//                    )
//            }
//
//            is Response.Error -> {
//                MaintenanceEmpty()
//            }
//        }
    }
}
