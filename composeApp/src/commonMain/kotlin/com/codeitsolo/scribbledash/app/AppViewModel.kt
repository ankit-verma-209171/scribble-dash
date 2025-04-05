package com.codeitsolo.scribbledash.app

import androidx.lifecycle.ViewModel
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator

class AppViewModel(
    private val navigator: Navigator,
): ViewModel() {

    val navIntents = navigator.intents
}