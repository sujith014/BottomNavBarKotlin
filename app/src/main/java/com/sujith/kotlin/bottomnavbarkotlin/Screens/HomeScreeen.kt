package com.sujith.kotlin.bottomnavbarkotlin.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = "HomeScreeen")
    }
}

@Preview(name = "HomeScreeen")
@Composable
private fun PreviewHomeScreeen() {
    HomeScreen()
}