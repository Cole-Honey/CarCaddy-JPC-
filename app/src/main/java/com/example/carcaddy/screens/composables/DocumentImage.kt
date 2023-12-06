package com.example.carcaddy.screens.composables

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DocumentImage(
    image: Uri,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(3.dp)
            .clip(RoundedCornerShape(10f))
           // .aspectRatio(2f) // Set the aspect ratio to achieve half the height of the width
            .graphicsLayer()
    ) {
        AsyncImage(
            model = image,
            contentScale = ContentScale.FillHeight,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize() // Make the image fill the entire Box
                .clip(RoundedCornerShape(10f)) // Clip the image with the same corner radius
                .graphicsLayer()
        )
    }
}




