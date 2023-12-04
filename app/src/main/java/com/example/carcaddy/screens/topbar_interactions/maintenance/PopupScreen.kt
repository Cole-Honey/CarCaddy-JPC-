package com.example.carcaddy.screens.topbar_interactions.maintenance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.screens.add_log_screen.AddLogScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopupScreen(
    onSave: (MaintenanceLog) -> Unit,
    isSheetOpen: Boolean,
    onCloseSheet: () -> Unit,
    modifier: Modifier = Modifier
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = onCloseSheet,
            modifier = modifier
                .fillMaxHeight(0.6f)
        ) {
            // Center the contents horizontally and vertically
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AddLogScreen(onSave = onSave)
            }
        }
    }
}