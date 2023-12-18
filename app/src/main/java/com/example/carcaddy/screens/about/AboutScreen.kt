package com.example.carcaddy.screens.about

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcaddy.screens.about.composables.FeedbackButton

@Composable
fun AboutScreen(
    activity: ComponentActivity,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // NHTSA
            Text(
                text = "Vehicle Information is powered by:",
                fontSize = 20.sp
            )
            Text(
                text = "NHTSA",
                fontSize = 40.sp
            )

        Spacer(modifier = Modifier.height(32.dp))

        // Business Inquires
        Text(
            text = "For Business Inquires:",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "cole@honeydevelopment.com",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(64.dp))

        FeedbackButton(activity = activity)
    }
}