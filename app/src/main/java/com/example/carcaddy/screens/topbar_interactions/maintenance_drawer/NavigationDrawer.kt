package com.example.carcaddy.screens.topbar_interactions.maintenance_drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryStd
import androidx.compose.material.icons.filled.CarRepair
import androidx.compose.material.icons.filled.OilBarrel
import androidx.compose.material.icons.filled.TireRepair
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.outlined.BatteryStd
import androidx.compose.material.icons.outlined.CarRepair
import androidx.compose.material.icons.outlined.OilBarrel
import androidx.compose.material.icons.outlined.TireRepair
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carcaddy.screens.composables.DrawerMenuItem
import com.example.carcaddy.screens.how_to.ChangeOil
import com.example.carcaddy.screens.navigation.Directions
import com.example.carcaddy.screens.topbar_interactions.maintenance_drawer.composables.DrawerBody
import com.example.carcaddy.screens.topbar_interactions.maintenance_drawer.composables.DrawerHeader

@Composable
fun DrawerContent(
    navController: NavController,
    onItemClick: (DrawerMenuItem) -> Unit,
    modifier: Modifier = Modifier
) {

    DrawerHeader()
    DrawerBody(
        items = listOf(
            DrawerMenuItem(
                id = "checkOil",
                title = "Check Oil",
                contentDescription = "Go To Check Oil Screen",
                icon = Icons.Outlined.OilBarrel
            ),
            DrawerMenuItem(
                id = "changeOil",
                title = "Change Oil",
                contentDescription = "Go To Change Oil Screen",
                icon = Icons.Filled.OilBarrel
            ),
            DrawerMenuItem(
                id = "checkBrakes",
                title = "Check Brakes",
                contentDescription = "Go To Check Brakes Screen",
                icon = Icons.Outlined.CarRepair
            ),
            DrawerMenuItem(
                id = "changeBrakes",
                title = "Change Brakes",
                contentDescription = "Go To Change Brakes Screen",
                icon = Icons.Filled.CarRepair
            ),
            DrawerMenuItem(
                id = "checkTransmissionFluid",
                title = "Check Transmission Fluid",
                contentDescription = "Go To Check Transmission Fluid Screen",
                icon = Icons.Outlined.WaterDrop
            ),
            DrawerMenuItem(
                id = "changeTransmissionFluid",
                title = "Change Transmission Fluid",
                contentDescription = "Go To Change Transmission Fluid Screen",
                icon = Icons.Filled.WaterDrop
            ),
            DrawerMenuItem(
                id = "checkTires",
                title = "Check Tires",
                contentDescription = "Go To Check Tires Screen",
                icon = Icons.Outlined.TireRepair
            ),
            DrawerMenuItem(
                id = "changeTires",
                title = "Change Tires",
                contentDescription = "Go To Change Tires Screen",
                icon = Icons.Filled.TireRepair
            ),
            DrawerMenuItem(
                id = "checkBattery",
                title = "Check Battery",
                contentDescription = "Go To Check Battery Screen",
                icon = Icons.Outlined.BatteryStd
            ),
            DrawerMenuItem(
                id = "changeBattery",
                title = "Change Battery",
                contentDescription = "Go To Change Battery Screen",
                icon = Icons.Filled.BatteryStd
            ),
        ),
        onItemClick = { item ->
            when (item.id) {
                "checkOil" -> navController.navigate(Directions.CheckOil.path)
                "changeOil" -> navController.navigate(Directions.ChangeOil.path)
                "checkBrakes" -> navController.navigate(Directions.CheckBrakes.path)
                "changeBrakes" -> navController.navigate(Directions.ChangeBrakes.path)
                "checkTransmissionFluid" -> navController.navigate(Directions.CheckTransmissionFluid.path)
                "changeTransmissionFluid" -> navController.navigate(Directions.ChangeTransmissionFluid.path)
                "checkTires" -> navController.navigate(Directions.CheckTires.path)
                "changeTires" -> navController.navigate(Directions.ChangeTires.path)
                "checkBattery" -> navController.navigate(Directions.CheckBattery.path)
                "changeBattery" -> navController.navigate(Directions.ChangeBattery.path)
            }
        }
    )
}