package com.example.carcaddy.screens.maintenance.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcaddy.model.MaintenanceLog
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun MaintenanceListItem(
    log: MaintenanceLog,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.clickable { onItemClick() }
    ) {
        Column(
            modifier = Modifier.weight(0.8f)
        ) {
            Text(
                text = "Type",
                fontSize = 15.sp,
                color = Color.Gray
            )
            LogText(log.maintenanceType.name)

            Text(
                text = "Date",
                fontSize = 15.sp,
                color = Color.Gray
            )
            LogText(log.date?.let { SimpleDateFormat("MMM dd", Locale.getDefault()).format(it) })

            Text(
                text = "Cost",
                fontSize = 15.sp,
                color = Color.Gray
            )
            LogText(log.cost.toString())
        }

        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Text(
                text = "Description",
                fontSize = 15.sp,
                color = Color.Gray
            )
            LogText(log.description)
        }

        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "Arrow to show item can be clicked",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}
