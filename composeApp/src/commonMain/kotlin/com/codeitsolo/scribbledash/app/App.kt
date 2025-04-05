package com.codeitsolo.scribbledash.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeitsolo.scribbledash.core.presentation.compose.FlowObservableEffect
import com.codeitsolo.scribbledash.feature.dashboard.presentation.DashboardRoute
import com.codeitsolo.scribbledash.ui.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()
        val viewModel: AppViewModel = koinViewModel()

        FlowObservableEffect(viewModel.navIntents) { intent ->
            navController.intent()
        }

        NavHost(
            startDestination = Dashboard,
            navController = navController
        ) {

            composable<Dashboard> {
                DashboardRoute()
            }
        }
    }
}
