package com.example.carcaddy.screens.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DatePicker(
    modifier: Modifier = Modifier,
    selectedDate: LocalDate, // Add a selectedDate property
    onDateSelected: (LocalDate) -> Unit // Add an onDateSelected callback
) {

    val dateDialogState = rememberMaterialDialogState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                dateDialogState.show()
            }
        ) {
            Text(text = "Pick Date")
        }

        // Display the selected date
        Text(text = DateTimeFormatter.ofPattern("MM dd yyyy").format(selectedDate))

        MaterialDialog(
            dialogState = dateDialogState
        ) {
            datepicker(
                initialDate = selectedDate, // Use the selectedDate property
                title = "Pick a date"
            ) {
                onDateSelected(it)
            }
        }
    }
}
