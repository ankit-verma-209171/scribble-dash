package com.codeitsolo.scribbledash.feature.game.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.codeitsolo.scribbledash.feature.game.presentation.common.GameTopAppBar
import com.codeitsolo.scribbledash.ui.theme.color.success
import com.codeitsolo.scribbledash.ui.theme.color.surfaceHigh
import com.codeitsolo.scribbledash.ui.theme.color.surfaceLowest
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.clear_canvas
import scribbledash.composeapp.generated.resources.game_title
import scribbledash.composeapp.generated.resources.ic_redo
import scribbledash.composeapp.generated.resources.ic_undo
import scribbledash.composeapp.generated.resources.img_board
import kotlin.math.abs

@Composable
fun GameRoute(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    GameScreen(
        modifier = modifier,
        uiState = uiState,
        onBackClick = viewModel::onBackClick,
        onUndoClick = viewModel::onUndoClick,
        onRedoClick = viewModel::onRedoClick,
        onClearCanvasClick = viewModel::onClearCanvasClick,
        onDrawingAction = viewModel::onDrawingAction
    )
}

@Composable
internal fun GameScreen(
    modifier: Modifier = Modifier,
    uiState: GameUiState,
    onBackClick: () -> Unit,
    onUndoClick: () -> Unit,
    onRedoClick: () -> Unit,
    onClearCanvasClick: () -> Unit,
    onDrawingAction: (DrawingAction) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            GameTopAppBar(
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 53.dp),
                text = stringResource(Res.string.game_title),
                style = MaterialTheme.typography.displayMedium
            )
            Board(
                modifier = Modifier
                    .padding(horizontal = 29.dp, vertical = 32.dp),
                paths = uiState.paths,
                currentPath = uiState.currentPath,
                onAction = onDrawingAction,
            )
            Spacer(
                Modifier
                    .weight(1f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 29.dp)
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionButton(
                    enabled = uiState.isUndoEnabled,
                    icon = Res.drawable.ic_undo,
                    contentDescription = "undo",
                    onClick = onUndoClick
                )

                ActionButton(
                    enabled = uiState.isRedoEnabled,
                    icon = Res.drawable.ic_redo,
                    contentDescription = "redo",
                    onClick = onRedoClick
                )

                ClearCanvasButton(
                    modifier = Modifier
                        .weight(1f),
                    enabled = uiState.isClearCanvasEnabled,
                    onClick = onClearCanvasClick
                )
            }
        }
    }
}

@Composable
private fun Board(
    modifier: Modifier,
    paths: List<PathData>,
    currentPath: PathData?,
    onAction: (DrawingAction) -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(36.dp))
                .background(MaterialTheme.colorScheme.surfaceHigh)
                .padding(12.dp)
                .fillMaxWidth()
                .aspectRatio(1f),
            painter = painterResource(Res.drawable.img_board),
            contentDescription = null
        )
        Canvas(
            modifier = Modifier
                .clipToBounds()
                .matchParentSize()
                .pointerInput(true) {
                    detectDragGestures(
                        onDragStart = {
                            onAction(DrawingAction.OnNewPathStart)
                        },
                        onDragEnd = {
                            onAction(DrawingAction.OnPathEnd)
                        },
                        onDrag = { change, _ ->
                            onAction(DrawingAction.OnDraw(change.position))
                        },
                        onDragCancel = {
                            onAction(DrawingAction.OnPathEnd)
                        },
                    )
                }
        ) {
            paths.fastForEach { pathData ->
                drawPath(
                    path = pathData.path,
                    color = Color.Black,
                )
            }
            currentPath?.let {
                drawPath(
                    path = it.path,
                    color = Color.Black
                )
            }
        }
    }
}

private fun DrawScope.drawPath(
    path: List<Offset>,
    color: Color,
    thickness: Float = 10f
) {
    val smoothedPath = Path().apply {
        if (path.isNotEmpty()) {
            moveTo(path.first().x, path.first().y)

            val smoothness = 5
            for (i in 1..path.lastIndex) {
                val from = path[i - 1]
                val to = path[i]
                val dx = abs(from.x - to.x)
                val dy = abs(from.y - to.y)
                if (dx >= smoothness || dy >= smoothness) {
                    quadraticTo(
                        x1 = (from.x + to.x) / 2f,
                        y1 = (from.y + to.y) / 2f,
                        x2 = to.x,
                        y2 = to.y
                    )
                }
            }
        }
    }
    drawPath(
        path = smoothedPath,
        color = color,
        style = Stroke(
            width = thickness,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round
        )
    )
}

@Composable
private fun ActionButton(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    contentDescription: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .clickable(enabled = enabled, onClick = onClick)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerLow
                    .copy(alpha = if (enabled) 1f else 0.4f)
            )
            .padding(18.dp)
            .size(28.dp),
        painter = painterResource(icon),
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(
            color = MaterialTheme.colorScheme.onBackground
                .copy(alpha = if (enabled) 1f else 0.4f)
        )
    )
}

@Composable
private fun ClearCanvasButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = DefaultShadowColor.copy(alpha = 0.3f),
                spotColor = DefaultShadowColor.copy(alpha = 0.2f),
            )
            .clip(RoundedCornerShape(20.dp))
            .clickable(enabled = enabled, onClick = onClick)
            .background(MaterialTheme.colorScheme.surfaceHigh)
            .padding(6.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (enabled) {
                    MaterialTheme.colorScheme.success
                } else {
                    MaterialTheme.colorScheme.surfaceLowest.copy(0.8f)
                }
            )
            .padding(vertical = 10.dp),
        text = stringResource(Res.string.clear_canvas),
        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onPrimary
    )
}