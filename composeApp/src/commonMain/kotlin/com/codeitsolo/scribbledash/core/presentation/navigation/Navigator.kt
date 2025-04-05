package com.codeitsolo.scribbledash.core.presentation.navigation

import kotlinx.coroutines.flow.Flow

/**
 * Navigator manages navigation inside the app.
 */
interface Navigator {

    /**
     * Navigation intents.
     */
    val intents: Flow<NavIntent>

    /**
     * Navigate back to previous screen.
     */
    fun navigateUp()

    /**
     * Navigate to [route], optionally popping off the back stack.
     *
     * @param route the route to navigate to.
     * @param popUpToRoute optional route to pop up to.
     * @param inclusive if true, pop up to [popUpToRoute] inclusively.
     */
    fun navigate(route: Any, popUpToRoute: Any? = null, inclusive: Boolean = false)
}