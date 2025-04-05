package com.codeitsolo.scribbledash.feature.dashboard.presentation

import org.jetbrains.compose.resources.DrawableResource
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.ic_chart
import scribbledash.composeapp.generated.resources.ic_home

data class DashboardUiState(
    val selectedTab: DashboardTab = DashboardTab.Home
)

enum class DashboardTab(val icon: DrawableResource) {
    Chart(icon = Res.drawable.ic_chart),
    Home(icon = Res.drawable.ic_home),
}