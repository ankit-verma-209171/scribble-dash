package com.codeitsolo.scribbledash.feature.game.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator
import com.codeitsolo.scribbledash.core.presentation.utils.getWhileSubscribedOrRetailed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn

class GameViewModel(
    private val navigator: Navigator,
) : ViewModel() {

    private val _uiState = MutableStateFlow(getDefaultUiState())
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = getWhileSubscribedOrRetailed(),
        initialValue = _uiState.value
    )

    fun onBackClick() {
        navigator.navigateUp()
    }

    fun onUndoClick() {
        // TODO: Undo impl
    }

    fun onRedoClick() {
        // TODO: Redo impl
    }

    fun onClearCanvasClick() {
        // TODO: Clear canvas impl
    }

    private fun getDefaultUiState() = GameUiState()
}