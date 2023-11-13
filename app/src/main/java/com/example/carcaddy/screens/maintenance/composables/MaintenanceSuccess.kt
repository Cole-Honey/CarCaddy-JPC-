package com.example.carcaddy.screens.maintenance.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.MaintenanceLog

@Composable
fun MaintenanceSuccess(
    logs: List<MaintenanceLog>,
    innerPadding: PaddingValues,
    onItemClick: (MaintenanceLog) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Log.d("Logs", "List of logs: $logs")
        items(logs) { log ->
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                MaintenanceListItem(log = log, onItemClick = { onItemClick(log) })
                Log.d("Logs", "$log")
            }
            Divider(
                color = Color.Black,
                thickness = 1.dp
            )
        }
    }
}