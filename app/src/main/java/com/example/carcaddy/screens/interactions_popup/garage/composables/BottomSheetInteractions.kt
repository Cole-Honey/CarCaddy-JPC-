package com.example.carcaddy.screens.interactions_popup.garage.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.edit_screen.EditScreen

@Composable
fun BottomSheetInteractions(
    vehicle: Vehicle,
    onSave: (Vehicle) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        EditScreen(vehicle = vehicle, onSave = onSave)
    }
}