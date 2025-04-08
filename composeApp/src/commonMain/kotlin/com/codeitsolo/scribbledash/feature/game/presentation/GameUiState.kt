package com.codeitsolo.scribbledash.feature.game.presentation

data class GameUiState(
    val isUndoEnabled: Boolean = false,
    val isRedoEnabled: Boolean = false,
    val isClearCanvasEnabled: Boolean = false,
)
