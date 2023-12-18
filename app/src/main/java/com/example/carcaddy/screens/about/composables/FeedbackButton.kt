package com.example.carcaddy.screens.about.composables

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedbackButton(activity: ComponentActivity) {
    val openUrl =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Handle the result if needed
        }

    DisposableEffect(activity) {
        onDispose {
            // Unregister the callback if needed
        }
    }

    Button(
        onClick = {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSeTsEy-pSwsXSltVbruUI-U0KVXarAON6Sc_6DZVFNfsVWGEA/viewform?usp=sharing")
            )
            openUrl.launch(intent)
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.Feedback, contentDescription = "Give Feedback")
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Give Feedback!",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}