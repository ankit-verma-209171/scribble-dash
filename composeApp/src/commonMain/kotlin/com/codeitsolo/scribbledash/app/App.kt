package com.codeitsolo.scribbledash.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeitsolo.scribbledash.feature.dashboard.presentation.DashboardRoute
import com.codeitsolo.scribbledash.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()

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
