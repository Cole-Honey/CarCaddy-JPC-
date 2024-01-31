package com.example.carcaddy.screens.topbar_interactions.garage.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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