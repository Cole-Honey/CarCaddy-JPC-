package com.example.carcaddy.screens.composables

import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RoundImage(
    image: Uri,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = image,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}