package com.codeitsolo.scribbledash.feature.game.presentation.start

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.unit.dp
import com.codeitsolo.scribbledash.feature.game.data.GameDifficulty
import com.codeitsolo.scribbledash.feature.game.presentation.common.GameTopAppBar
import com.codeitsolo.scribbledash.ui.theme.color.onBackgroundVariant
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.beginner_difficulty
import scribbledash.composeapp.generated.resources.challenging_difficulty
import scribbledash.composeapp.generated.resources.ic_difficulty_beginner
import scribbledash.composeapp.generated.resources.ic_difficulty_challenging
import scribbledash.composeapp.generated.resources.ic_difficulty_master
import scribbledash.composeapp.generated.resources.master_difficulty
import scribbledash.composeapp.generated.resources.start_game_sub_title
import scribbledash.composeapp.generated.resources.start_game_title

@Composable
internal fun StartGameRoute(
    modifier: Modifier = Modifier,
    viewModel: StartGameViewModel = koinViewModel(),
) {
    StartGameScreen(
        modifier = modifier,
        onBackClick = viewModel::onBackClick,
        onChooseDifficultyClick = viewModel::onChooseDifficultyClick,
    )
}

@Composable
internal fun StartGameScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onChooseDifficultyClick: (difficulty: GameDifficulty) -> Unit,
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
            Heading(
                modifier = Modifier
                    .padding(top = 126.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 55.dp),
                horizontalArrangement = Arrangement.spacedBy(36.dp)
            ) {
                DifficultySetting(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    icon = Res.drawable.ic_difficulty_beginner,
                    text = stringResource(Res.string.beginner_difficulty),
                    onClick = { onChooseDifficultyClick(GameDifficulty.Beginner) }
                )
                DifficultySetting(
                    icon = Res.drawable.ic_difficulty_challenging,
                    text = stringResource(Res.string.challenging_difficulty),
                    onClick = { onChooseDifficultyClick(GameDifficulty.Challenging) }
                )
                DifficultySetting(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    icon = Res.drawable.ic_difficulty_master,
                    text = stringResource(Res.string.master_difficulty),
                    onClick = { onChooseDifficultyClick(GameDifficulty.Master) }
                )
            }
        }
    }
}

@Composable
private fun Heading(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(Res.string.start_game_title),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(Res.string.start_game_sub_title),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackgroundVariant,
        )
    }
}

@Composable
private fun DifficultySetting(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    text: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier
                .size(88.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = CircleShape,
                    ambientColor = DefaultShadowColor.copy(alpha = 0.3f),
                    spotColor = DefaultShadowColor.copy(alpha = 0.2f),
                )
                .clip(CircleShape)
                .clickable(onClick = onClick),
            painter = painterResource(icon),
            contentDescription = "beginner difficulty",
            tint = Color.Unspecified,
        )
        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .clickable(onClick = onClick),
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackgroundVariant,
        )
    }
}