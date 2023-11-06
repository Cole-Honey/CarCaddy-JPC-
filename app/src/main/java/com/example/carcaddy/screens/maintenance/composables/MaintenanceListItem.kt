package com.example.carcaddy.screens.maintenance.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.carcaddy.model.MaintenanceLog

@Composable
fun MaintenanceListItem(
    log: MaintenanceLog,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .clickable { onItemClick() }
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .weight(.80f)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
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
//                    LogText(log.date.toString())
                    Text(
                        text = "Cost",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                    LogText(log.cost.toString())
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .weight(.20f)
            ) {
                Text(
                    text = "Description",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                LogText(log.description)
            }
        }

        Icon(
            modifier = Modifier.weight(0.15f),
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "Arrow to show item can be clicked",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}