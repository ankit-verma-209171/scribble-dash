package com.codeitsolo.scribbledash.feature.dashboard.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.codeitsolo.scribbledash.feature.chart.presentation.ChartRoute
import com.codeitsolo.scribbledash.feature.home.presentation.HomeRoute
import com.codeitsolo.scribbledash.ui.theme.color.surfaceHigh
import com.codeitsolo.scribbledash.ui.theme.color.surfaceLowest
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun DashboardRoute(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = koinViewModel<DashboardViewModel>()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DashboardScreen(
        modifier = modifier,
        uiState = uiState,
        onTabClick = viewModel::onTabClick,
    )
}

@Composable
private fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState,
    onTabClick: (DashboardTab) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            DashboardBottomAppBar(
                selectedTab = uiState.selectedTab,
                onTabClick = onTabClick
            )
        }
    ) {
        Crossfade(
            targetState = uiState.selectedTab
        ) {
            when (it) {
                DashboardTab.Chart -> ChartRoute()
                DashboardTab.Home -> HomeRoute()
            }
        }
    }
}

@Composable
private fun DashboardBottomAppBar(
    modifier: Modifier = Modifier,
    selectedTab: DashboardTab,
    onTabClick: (DashboardTab) -> Unit,
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceHigh,
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                DashboardTab.entries.fastForEach {
                    IconButton(onClick = { onTabClick(it) }) {
                        Icon(
                            modifier = Modifier
                                .size(32.dp),
                            painter = painterResource(it.icon),
                            contentDescription = null,
                            tint = if (it == selectedTab) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.surfaceLowest
                            },
                        )
                    }
                }
            }
        }
    )
}
