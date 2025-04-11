package com.codeitsolo.scribbledash.feature.game.presentation

import androidx.compose.ui.geometry.Offset
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class GameUiState(
    val isUndoEnabled: Boolean = false,
    val isRedoEnabled: Boolean = false,
    val currentPath: PathData? = null,
    val paths: List<PathData> = emptyList()
) {

    val isClearCanvasEnabled: Boolean = paths.isNotEmpty()
}

@OptIn(ExperimentalUuidApi::class)
data class PathData(
    val id: String = Uuid.random().toString(),
    val path: List<Offset>
)

sealed interface DrawingAction {
    data object OnNewPathStart : DrawingAction
    data class OnDraw(val offset: Offset) : DrawingAction
    data object OnPathEnd : DrawingAction
    data object OnClearCanvasClick : DrawingAction
}