package com.example.carcaddy.screens.composables

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun DatePicker(
    selectedDate: LocalDate?, // Add a selectedDate property
    onDateSelected: (LocalDate) -> Unit, // Add an onDateSelected callback
    isPickerOpen: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier

) {

    val dateDialogState = rememberMaterialDialogState(true)

    if (isPickerOpen) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            MaterialDialog(
                dialogState = dateDialogState,
                buttons = {
                    positiveButton(text = "Ok") {
                        onDismissRequest()
                    }
                    negativeButton(text = "Cancel") {
                        onDismissRequest()
                    }
                }
            ) {
                selectedDate?.let {
                    datepicker(
                        initialDate = it, // Use the selectedDate property
                        title = "Pick a date"
                    ) {
                        onDateSelected(it)
                    }
                }
            }
        }
    }
}
