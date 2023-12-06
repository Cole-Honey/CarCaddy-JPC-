package com.example.carcaddy.screens.log_detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.screens.composables.DocumentImage
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogDetailSuccess(
    log: MaintenanceLog,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    // Spacing between elements
    val spacerHeight = 16.dp

    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd")

    // Main LazyColumn
    LazyColumn(
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        item {
            Column {
                // Type and Date in a single row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Maintenance Type
                    Column {
                        LabelText(text = "|Type|")
                        LogText(text = log.maintenanceType.name.lowercase().capitalize(Locale.ROOT))
                    }

                    // Maintenance Date
                    Column {
                        LabelText(text = "|Date|")
                        LogText(text = log.date?.format(dateFormatter))
                    }
                }

                Spacer(modifier = Modifier.height(spacerHeight))

                // Cost
                LabelText(text = "|Cost|")
                LogText(text = "$${log.cost}")

                Spacer(modifier = Modifier.height(spacerHeight))

                // Description
                LabelText(text = "|Description|")
                LogText(text = log.description)

                Spacer(modifier = Modifier.height(spacerHeight))

                // Documentation
                LabelText(text = "|Documentation|")
                log.image?.let {
                    DocumentImage(
                        image = it,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
