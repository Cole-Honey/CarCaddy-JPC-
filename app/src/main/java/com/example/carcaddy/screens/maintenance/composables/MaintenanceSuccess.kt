package com.example.carcaddy.screens.maintenance.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.carcaddy.model.MaintenanceLog
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MaintenanceSuccess(
    logs: List<MaintenanceLog>,
    innerPadding: PaddingValues,
    onItemClick: (MaintenanceLog) -> Unit,
    onItemDelete: (MaintenanceLog) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    LazyColumn(
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.tertiary)
    ) {

        items(items = logs, key = { log -> log.logId }) { log ->
            // Remembering dismiss state for each item
            val dismissState = rememberDismissState(
                initialValue = DismissValue.Default,
                // Adjusting the swipe activation threshold for a smoother experience
                positionalThreshold = { swipeActivationFloat -> swipeActivationFloat / 2 }
            )

            // Implementing swipe-to-dismiss gesture
            SwipeToDismiss(
                modifier = Modifier.animateItemPlacement(),
                state = dismissState,
                // Customizing the background color based on the swipe direction
                background = {
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.Default -> Color.Transparent
                            DismissValue.DismissedToEnd -> Color.Red
                            DismissValue.DismissedToStart -> Color.Red
                        }, label = ""
                    )
                    // Drawing a colored background based on the swipe direction
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color),
                        contentAlignment = Alignment.Center
                    ) {
                        Row {
                            // Show the refresh icon only when swiping is happening
                            if (dismissState.targetValue == DismissValue.DismissedToStart) {
                                IconButton(onClick = { scope.launch { dismissState.reset() } }) {
                                    Icon(
                                        imageVector = Icons.Default.Refresh,
                                        contentDescription = "Refresh"
                                    )
                                }
                            }
                            if (dismissState.targetValue == DismissValue.DismissedToStart)
                                IconButton(onClick = {
                                    onItemDelete(log)
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete"
                                    )
                                }
                        }
                    }
                },
                // Customizing the dismiss content with improved UI
                dismissContent = {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        MaintenanceListItem(
                            log = log,
                            onItemClick = { onItemClick(log) },
                            onItemDelete = { onItemDelete(log) }
                        )
                    }
                }
            )
            Divider(
                color = Color.LightGray,
                thickness = 1.dp
            )
        }
    }
}