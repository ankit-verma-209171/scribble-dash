package com.codeitsolo.scribbledash.di

import com.codeitsolo.scribbledash.app.AppViewModel
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator
import com.codeitsolo.scribbledash.core.presentation.navigation.NavigatorImpl
import com.codeitsolo.scribbledash.feature.dashboard.presentation.DashboardViewModel
import com.codeitsolo.scribbledash.feature.game.presentation.GameViewModel
import com.codeitsolo.scribbledash.feature.game.presentation.start.StartGameViewModel
import com.codeitsolo.scribbledash.feature.home.presentation.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    viewModelOf(::DashboardViewModel)
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::StartGameViewModel)
    viewModelOf(::GameViewModel)
    singleOf(::NavigatorImpl).bind<Navigator>()
}