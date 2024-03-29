package com.example.carcaddy.screens.maintenance.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.FilePresent
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
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun MaintenanceListItem(
    log: MaintenanceLog,
    onItemClick: () -> Unit,
    onItemDelete: () -> Unit,
    modifier: Modifier = Modifier
) {

    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd")

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.clickable { onItemClick() }
    ) {
        Column(
            modifier = Modifier.weight(0.9f)
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1.45f)
                ) {
                    Text(
                        text = "Type",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                    ListItemLogText(log.maintenanceType.name.lowercase().capitalize(Locale.ROOT))
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Date",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                    ListItemLogText(log.date?.format(dateFormatter))
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Cost",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                    ListItemLogText(log.cost.toString())
                }

                Column(
                    modifier = Modifier.weight(0.3f)
                ) {
                    if (log.image != null) {
                        Icon(
                            imageVector = Icons.Outlined.FilePresent,
                            contentDescription = "Upload File"
                        )
                    }
                }
            }

            Column {
                Text(
                    text = "Description",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                ListItemLogText(log.description)
            }
        }
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "Arrow to show item can be clicked",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}
