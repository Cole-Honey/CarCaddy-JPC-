package com.example.carcaddy.screens.interactions_popup.maintenance.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.screens.add_log_screen.AddLogScreen
import java.util.Date

@Composable
fun BottomSheet(
    onSave: (MaintenanceLog) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        AddLogScreen(onSave)
    }
}
