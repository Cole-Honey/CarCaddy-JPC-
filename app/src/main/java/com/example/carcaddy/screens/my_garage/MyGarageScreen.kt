package com.example.carcaddy.screens.my_garage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MyGarageScreen(
    navigator: DestinationsNavigator,
    image: Painter,
    modifier: Modifier = Modifier,
    viewModel: MyGarageViewModel = hiltViewModel()
) {

    val vehiclesState by viewModel.vehicles.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier
    ) {
        item {
            Row {
                Column {
                    Text(text = "Name")
                    Image(
                        painter = image,
                        contentDescription = "Car Image",
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.Transparent)
                            .border(1.dp, Color.Black, shape = CircleShape)
                    )
                    Column {
                        Text(text = "Year")
                        Text(text = "Make")
                    }
                    Column {
                        Text(text = "Model")
                        Text(text = "Mileage")
                    }
                }
            }
        }
    }
}