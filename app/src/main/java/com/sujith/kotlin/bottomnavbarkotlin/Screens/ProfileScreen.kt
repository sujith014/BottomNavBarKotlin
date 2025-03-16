package com.sujith.kotlin.bottomnavbarkotlin.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier,
        contentAlignment = Alignment.Center
        ) {
        Text(text = "ProfileScreen")
    }
}

@Preview(name = "ProfileScreen")
@Composable
private fun PreviewProfileScreen() {
    ProfileScreen()
}