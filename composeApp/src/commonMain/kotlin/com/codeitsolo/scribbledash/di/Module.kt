package com.codeitsolo.scribbledash.di

import com.codeitsolo.scribbledash.app.AppViewModel
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator
import com.codeitsolo.scribbledash.core.presentation.navigation.NavigatorImpl
import com.codeitsolo.scribbledash.feature.dashboard.presentation.DashboardViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    viewModelOf(::DashboardViewModel)
    viewModelOf(::AppViewModel)
    singleOf(::NavigatorImpl).bind<Navigator>()
}