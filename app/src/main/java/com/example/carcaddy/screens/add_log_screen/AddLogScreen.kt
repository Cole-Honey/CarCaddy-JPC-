package com.example.carcaddy.screens.add_log_screen

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.model.MaintenanceLog.MaintenanceType
import com.example.carcaddy.screens.composables.PhotoPicker
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun AddLogScreen(
    onSave: (MaintenanceLog) -> Unit,
    modifier: Modifier = Modifier
) {
    // State variables
    val selectedDate by remember { mutableStateOf(Date()) }
    var maintenanceType by remember { mutableStateOf(MaintenanceType.CHOOSE_TYPE) }
    var costText by remember { mutableStateOf("0.0") }
    var description by remember { mutableStateOf("") }
    var image by remember { mutableStateOf<Uri?>(null) }
    val vin by remember { mutableStateOf("") }

    // Options for MaintenanceType dropdown
    val maintenanceTypeOptions = MaintenanceType.values().map { it.name }

    // State to track whether the dropdown is expanded
    var isDropdownExpanded by remember { mutableStateOf(false) }

    // State for scrollState
    val scrollState = rememberScrollState()

    // UI layout
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(1000.dp)
    ) {
        Column(
            modifier = modifier
                .verticalScroll(
                    state = scrollState,
                    enabled = true
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Date input
            OutlinedTextField(
                value = SimpleDateFormat("MM/dd/yyyy").format(selectedDate),
                onValueChange = { /* Update selectedDate */ },
                label = { Text("Date") },
                readOnly = true,
                modifier = Modifier.clickable {
                    // Show the DatePicker when the field is clicked
                    // showDialog.value = true
                }
            )

            // Maintenance Type Selection
            Box(
                modifier = Modifier.clickable {
                    // Toggle the dropdown visibility
                    isDropdownExpanded = !isDropdownExpanded
                }
            ) {
                Text("Maintenance Type: $maintenanceType")

                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = {
                        isDropdownExpanded = false
                    },
                    modifier = Modifier.background(MaterialTheme.colorScheme.background)
                ) {
                    maintenanceTypeOptions.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                maintenanceType = MaintenanceType.valueOf(option)
                                isDropdownExpanded = false
                            },
                            text = {
                                Text(option)
                            }
                        )
                    }
                }
            }

            // Cost Input
            OutlinedTextField(
                value = costText,
                onValueChange = {
                    costText = it
                },
                label = { Text("Cost") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            // Description Input
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text,
                ),
                singleLine = false
            )

            // Photo Input
            PhotoPicker(
                buttonText = "Upload Document",
                mutableImageState = image,
                onImageSelected = { selectedImage -> image = selectedImage }
            )

            // Save Button
            Button(
                onClick = {
                    onSave(
                        MaintenanceLog(
                            maintenanceType = maintenanceType,
                            date = selectedDate,
                            cost = costText.toDouble(),
                            description = description,
                            image = image,
                            vin = vin
                        )
                    )
                }
            ) {
                Text("Save Log")
            }
        }
    }
}
