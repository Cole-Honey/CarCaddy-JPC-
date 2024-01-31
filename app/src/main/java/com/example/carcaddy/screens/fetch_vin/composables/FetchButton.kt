package com.example.carcaddy.screens.fetch_vin.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun FetchButton(
    onClickLambda: () -> Unit,
    image: ImageVector,
    desc: String
) {

    IconButton(onClick = {
        onClickLambda()
    }) {
        Icon(
            imageVector = image,
            contentDescription = desc,
        )

    }
}