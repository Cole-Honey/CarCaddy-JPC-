package com.example.carcaddy.screens.interactions_popup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.interactions_popup.composables.BottomSheetInteractions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InteractionsPopupScreen(
    vehicle: Vehicle,
    onSave: (Vehicle) -> Unit,
    isSheetOpen: Boolean,
    onCloseSheet: () -> Unit,
    modifier: Modifier = Modifier
) {

    val sheetState = rememberModalBottomSheetState()

    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = onCloseSheet,
            modifier = modifier
                .fillMaxHeight(0.6f)
        ) {
            // Center the contents horizontally and vertically
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BottomSheetInteractions(
                    vehicle = vehicle,
                    onSave = { vehicle ->
                        onSave(vehicle)
                    }
                )
            }
        }
    }
}
