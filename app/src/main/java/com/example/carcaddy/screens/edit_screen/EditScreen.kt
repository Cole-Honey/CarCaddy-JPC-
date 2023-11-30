package com.example.carcaddy.screens.edit_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.screens.composables.PhotoPicker

@Composable
fun EditScreen(
    vehicle: Vehicle,
    onSave: (Vehicle) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf(vehicle.name) }
    var mileage by remember { mutableStateOf(vehicle.mileage) }
    var vehicleImage by remember { mutableStateOf(vehicle.image) }
    var insuranceImage by remember { mutableStateOf(vehicle.insuranceImage) }
    var registrationImage by remember { mutableStateOf(vehicle.registrationImage) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name ?: "",
                onValueChange = { name = it },
                label = { Text(text = "Vehicle Name") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = mileage ?: "",
                onValueChange = { mileage = it },
                label = { Text(text = "Mileage") }
            )

            Spacer(modifier = Modifier.height(6.dp))
            Divider()
            Text(text = "Choose Images")
            Spacer(modifier = Modifier.height(6.dp))


            PhotoPicker(
                buttonText = "Vehicle",
                mutableImageState = vehicleImage,
                onImageSelected = { updatedImage -> vehicleImage = updatedImage }
            )

            Spacer(modifier = Modifier.height(12.dp))


            PhotoPicker(
                buttonText = "Insurance",
                mutableImageState = insuranceImage,
                onImageSelected = { updatedImage -> insuranceImage = updatedImage }
            )

            Spacer(modifier = Modifier.height(12.dp))


            PhotoPicker(
                buttonText = "Registration",
                mutableImageState = registrationImage,
                onImageSelected = { updatedImage -> registrationImage = updatedImage }
            )

            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Spacer(modifier = Modifier.height(12.dp))

        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 25.dp)
        ) {
            Button(
                onClick = {
                    val updateVehicle = vehicle.copy(
                        name = name,
                        mileage = mileage,
                        image = vehicleImage,
                        insuranceImage = insuranceImage,
                        registrationImage = registrationImage
                    )
                    onSave(updateVehicle)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}
