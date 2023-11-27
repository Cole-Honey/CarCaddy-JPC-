package com.example.carcaddy.screens.maintenance

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.carcaddy.screens.maintenance.composables.MaintenanceEmpty
import com.example.carcaddy.screens.maintenance.composables.MaintenanceLoading
import com.example.carcaddy.screens.maintenance.composables.MaintenanceSuccess
import com.example.carcaddy.screens.maintenance.composables.MaintenanceTopBar
import com.example.carcaddy.screens.topbar_interactions.maintenance.PopupScreen
import com.example.carcaddy.screens.topbar_interactions.maintenance_drawer.DrawerScreen
import com.example.carcaddy.utils.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaintenanceScreen(
    vin: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MaintenanceViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getAllLogs(viewModel.passedLogs)
    }

    val logsState by viewModel.logs.collectAsStateWithLifecycle()

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState(), { true })

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var isDrawerOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val openBottomSheet: () -> Unit = {
        isSheetOpen = true
    }

    val openDrawer: () -> Unit = {
        Log.d("Drawer", "Drawer is $isDrawerOpen")
        isDrawerOpen = true
        Log.d("Drawer", "Drawer is now $isDrawerOpen")
    }

    Scaffold(
        topBar = {
            MaintenanceTopBar(
                scrollBehavior = scrollBehavior,
                openScreen = { openBottomSheet() },
                openDrawer = { openDrawer() }
            )
        }
    ) { innerPadding ->

        when (val state = logsState) {
            is Response.Loading -> {
                MaintenanceLoading()
            }

            is Response.Success -> {
                MaintenanceSuccess(
                    logs = state.data,
                    innerPadding = innerPadding,
                    onItemClick = { log ->
                        viewModel.onLogClicked(log)
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

                if (isDrawerOpen) {
                    DrawerScreen()
                }
            }

            is Response.Error -> {
                MaintenanceEmpty()
            }
        }
    }
}
