package com.example.carcaddy.screens.tab_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.carcaddy.screens.tab_bar.composables.BottomNavigationItem
import com.example.carcaddy.screens.vehicle_details.VehicleDetailsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarScreen(
    vin: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    
    val screens = listOf("Home", "Maintenance", "Map")

    var selectedItem by rememberSaveable {
        mutableStateOf(screens.first())
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = getIconForScreen(screen = screen),
                                contentDescription = screen,
                                tint = if (screen == selectedItem) {
                                    Color.Black
                                } else {
                                    Color.Gray
                                }
                            )
                        },
                        label = {
                            Text(
                                text = screen,
                                fontWeight = if (screen == selectedItem) {
                                    FontWeight.Bold
                                } else {
                                    FontWeight.Normal
                                }
                            )
                        },
                        selected = screen == selectedItem,
                        selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                        onClick = { selectedItem = screen },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                getScreenForEachTab(
                    screen = selectedItem,
                    navController = navController
                )
            }
        }
    )
}

@Composable
fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Home" -> Icons.Filled.DirectionsCar
        "Maintenance" -> Icons.Filled.LibraryBooks
        "Map" -> Icons.Filled.Map
        else -> Icons.Filled.Warning
    }
}

@Composable
fun getScreenForEachTab(screen: String, navController: NavController) {
    when (screen) {
        "Home" -> VehicleDetailsScreen(navController)
//        "Maintenance" -> MaintenanceScreen()
//        "Map" -> MapScreen()
        else -> Text(text = "Selected Screen: $screen")
    }
}