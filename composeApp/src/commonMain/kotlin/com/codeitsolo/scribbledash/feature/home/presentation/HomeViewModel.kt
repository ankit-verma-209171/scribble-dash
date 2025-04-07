package com.codeitsolo.scribbledash.feature.home.presentation

import androidx.lifecycle.ViewModel
import com.codeitsolo.scribbledash.app.StartGame
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator

internal class HomeViewModel(
    private val navigator: Navigator,
) : ViewModel() {

    fun onOneRoundWonderClick() {
        navigator.navigate(StartGame)
    }
}