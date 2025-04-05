package com.codeitsolo.scribbledash.core.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * Collects values from a [Flow] when the lifecycle is at least in the [Lifecycle.State.STARTED] state.
 *
 * The [collect] callback will be called with each new value emitted by the [Flow].
 *
 * @param flow the flow to collect.
 * @param key a key to be used to restart the collection if it changes.
 * @param collect the callback to be called when a new value is emitted.
 * @param T the type of the values emitted by the [Flow].
 */
@Composable
fun <T> FlowObservableEffect(
    flow: Flow<T>,
    key: Any? = null,
    collect: (T) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner.lifecycle, key) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                flow.collect(collect)
            }
        }
    }
}