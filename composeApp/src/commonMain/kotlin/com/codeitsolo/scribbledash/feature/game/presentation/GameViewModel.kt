package com.codeitsolo.scribbledash.feature.game.presentation

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator
import com.codeitsolo.scribbledash.core.presentation.utils.getWhileSubscribedOrRetailed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class GameViewModel(
    private val navigator: Navigator,
) : ViewModel() {

    private val _uiState = MutableStateFlow(getDefaultUiState())
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = getWhileSubscribedOrRetailed(),
        initialValue = _uiState.value
    )

    private var pastPaths: ArrayDeque<List<PathData>> = ArrayDeque(5)
    private var futurePaths: ArrayDeque<List<PathData>> = ArrayDeque(5)

    fun onBackClick() {
        navigator.navigateUp()
    }

    fun onUndoClick() {
        val futurePath = pastPaths.removeLastOrNull() ?: return
        futurePaths.addLast(futurePath)
        _uiState.update {
            it.copy(
                currentPath = null,
                paths = pastPaths.lastOrNull().orEmpty(),
                isUndoEnabled = pastPaths.isNotEmpty(),
                isRedoEnabled = true,
            )
        }
    }

    fun onRedoClick() {
        val pastPath = futurePaths.removeLastOrNull() ?: return
        pastPaths.addLast(pastPath)
        _uiState.update {
            it.copy(
                currentPath = null,
                paths = pastPath,
                isRedoEnabled = futurePaths.isNotEmpty(),
                isUndoEnabled = true
            )
        }
    }

    fun onClearCanvasClick() {
        _uiState.update {
            it.copy(
                currentPath = null,
                paths = emptyList(),
                isUndoEnabled = false,
                isRedoEnabled = false
            )
        }
        pastPaths.clear()
        futurePaths.clear()
    }

    fun onDrawingAction(action: DrawingAction) {
        when (action) {
            DrawingAction.OnClearCanvasClick -> onClearCanvasClick()
            is DrawingAction.OnDraw -> onDraw(action.offset)
            DrawingAction.OnNewPathStart -> onNewPathStart()
            DrawingAction.OnPathEnd -> onPathEnd()
        }
    }

    private fun onPathEnd() {
        val currentPathData = uiState.value.currentPath ?: return
        _uiState.update {
            it.copy(
                currentPath = null,
                paths = it.paths + currentPathData,
                isUndoEnabled = true,
                isRedoEnabled = futurePaths.isNotEmpty()
            )
        }
        val latestPaths = _uiState.value.paths
        pastPaths.addLast(latestPaths)
    }

    private fun onNewPathStart() {
        _uiState.update {
            it.copy(
                currentPath = PathData(
                    path = emptyList()
                )
            )
        }
    }

    private fun onDraw(offset: Offset) {
        val currentPathData = uiState.value.currentPath ?: return
        _uiState.update {
            it.copy(
                currentPath = currentPathData.copy(
                    path = currentPathData.path + offset
                )
            )
        }
    }

    private fun getDefaultUiState() = GameUiState()
}