package com.example.carcaddy.screens.add_log_screen

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.model.MaintenanceLog.MaintenanceType
import com.example.carcaddy.screens.composables.DatePicker
import com.example.carcaddy.screens.composables.PhotoPicker
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddLogScreen(
    onSave: (MaintenanceLog) -> Unit,
    modifier: Modifier = Modifier
) {
    // State variables
    var selectedDate by remember { mutableStateOf<LocalDate?>(LocalDate.now()) }
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

    // Keyboard Controller
    val keyboardController = LocalSoftwareKeyboardController.current

    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

    // Dialog State
    var isDatePickerVisible by remember { mutableStateOf(false) }

    val openPicker: () -> Unit = {
        isDatePickerVisible = true
    }

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

            selectedDate?.let {
                Text(
                    text = it.format(dateFormatter),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            // Date input
            Button(onClick = { openPicker() }) {
                Text(
                    text = "Choose Date",
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            DatePicker(
                isPickerOpen = isDatePickerVisible,
                selectedDate = selectedDate,
                onDismissRequest = { isDatePickerVisible = false },
                onDateSelected = { date ->
                    selectedDate = date.atStartOfDay().toLocalDate()
                }
            )

            // Maintenance Type Selection
            Box(
                modifier = Modifier.clickable {
                    // Toggle the dropdown visibility
                    isDropdownExpanded = !isDropdownExpanded
                }
            ) {

                Row {
                    Text(
                        text = "Maintenance Type: $maintenanceType",
                        color = MaterialTheme.colorScheme.secondary

                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Choose Maintenance Type",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }

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
                                Text(
                                    text = option,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        )
                    }
                }
            }

            // Cost Input
            OutlinedTextField(
                value = costText,
                onValueChange = {
                    costText = if (it.contains(",")) {
                        val cleanedValue = it.replace(",", "")
                        cleanedValue
                    } else {
                        it
                    }
                },
                label = { Text(text = "Cost", color = MaterialTheme.colorScheme.secondary) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(onSearch = {
                    keyboardController?.hide()
                }),
                singleLine = true
            )

            // Description Input
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(text = "Description", color = MaterialTheme.colorScheme.secondary) },
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
                Text(
                    text = "Save Log",
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
