package com.example.carcaddy.screens.log_detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.screens.composables.DocumentImage
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun LogDetailSuccess(
    log: MaintenanceLog,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 16.dp)
    ) {
        item {
            Column {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    // Type top left
                    Column {
                        Text(
                            text = "Type"
                        )
                        LogText(text = log.description)
                    }

                    Spacer(modifier = Modifier.fillMaxWidth())

                    // Date top Right
                    LogText(
                        text = log.date?.let {
                            SimpleDateFormat("MMM dd", Locale.getDefault()).format(it)
                        }
                    )
                }

                // Cost
                Text(
                    text = "Cost",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                LogText(text = log.cost.toString())

                Spacer(modifier = Modifier.height(16.dp))

                // Description
                Text(
                    text = "Description",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                LogText(text = log.description)

                Spacer(modifier = Modifier.height(16.dp))

                // Documentation
                Text(
                    text = "Documentation",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                log.image?.let {
                    DocumentImage(
                        image = it
                    )
                }
            }
        }
    }
}