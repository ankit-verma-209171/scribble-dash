package com.codeitsolo.scribbledash.feature.chart.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ChartRoute(
    modifier: Modifier = Modifier
) {
    ChartScreen(
        modifier = modifier
    )
}

@Composable
private fun ChartScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Chart coming soon...")
    }
}