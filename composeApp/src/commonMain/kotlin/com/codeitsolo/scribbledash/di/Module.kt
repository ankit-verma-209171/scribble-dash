package com.codeitsolo.scribbledash.di

import com.codeitsolo.scribbledash.feature.dashboard.presentation.DashboardViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    viewModelOf(::DashboardViewModel)
}