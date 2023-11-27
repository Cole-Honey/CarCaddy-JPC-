package com.example.carcaddy.screens.maintenance.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Dehaze
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.carcaddy.screens.topbar_interactions.maintenance_drawer.DrawerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaintenanceTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    openDrawer: () -> Unit,
    openScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        title = {
            Text(
                text = "Logs",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },

        navigationIcon = {
            IconButton(onClick = { openDrawer() }) {
                Icon(
                    imageVector = Icons.Outlined.Dehaze,
                    contentDescription = "How To, Drop Down Tab Menu",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },

        actions = {
            IconButton(onClick = openScreen) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Log To Vehicle",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}