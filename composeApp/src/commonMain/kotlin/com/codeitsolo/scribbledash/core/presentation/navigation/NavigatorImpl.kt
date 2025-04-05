package com.codeitsolo.scribbledash.core.presentation.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Concrete implementation of [Navigator]
 */
class NavigatorImpl : Navigator {

    private val _intent = Channel<NavIntent>()
    override val intents: Flow<NavIntent> = _intent.receiveAsFlow()

    override fun navigateUp() {
        _intent.trySend {
            this.navigateUp()
        }
    }

    override fun navigate(route: Any, popUpToRoute: Any?, inclusive: Boolean) {
        _intent.trySend {
            this.navigate(route) {
                popUpToRoute?.let {
                    popUpTo(it) {
                        this.inclusive = inclusive
                    }
                }
            }
        }
    }
}