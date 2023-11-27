package com.example.carcaddy.screens.topbar_interactions.maintenance_drawer

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.OilBarrel
import androidx.compose.material.icons.filled.Texture
import androidx.compose.material.icons.outlined.OilBarrel
import androidx.compose.material.icons.outlined.Texture
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carcaddy.screens.composables.NavigationItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScreen() {

    val items = listOf(
        NavigationItem(
            title = "Oil",
            selectedIcon = Icons.Filled.OilBarrel,
            unselectedIcon = Icons.Outlined.OilBarrel
        ),
        NavigationItem(
            title = "Brakes",
            selectedIcon = Icons.Filled.Texture,
            unselectedIcon = Icons.Outlined.Texture
        ),
        NavigationItem(
            title = "Transmission",
            selectedIcon = Icons.Filled.Texture,
            unselectedIcon = Icons.Outlined.Texture
        ),
        NavigationItem(
            title = "Fuel",
            selectedIcon = Icons.Filled.Texture,
            unselectedIcon = Icons.Outlined.Texture
        ),
        NavigationItem(
            title = "Tires",
            selectedIcon = Icons.Filled.Texture,
            unselectedIcon = Icons.Outlined.Texture
        ),
        NavigationItem(
            title = "Battery",
            selectedIcon = Icons.Filled.Texture,
            unselectedIcon = Icons.Outlined.Texture
        ),
        NavigationItem(
            title = "Miscellaneous",
            selectedIcon = Icons.Filled.Texture,
            unselectedIcon = Icons.Outlined.Texture
        ),
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState
    ) {

    }
}
