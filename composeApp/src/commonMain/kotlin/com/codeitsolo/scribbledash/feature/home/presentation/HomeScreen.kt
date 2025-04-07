package com.codeitsolo.scribbledash.feature.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codeitsolo.scribbledash.ui.theme.color.onBackgroundVariant
import com.codeitsolo.scribbledash.ui.theme.color.success
import com.codeitsolo.scribbledash.ui.theme.color.surfaceHigh
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.home_sub_title
import scribbledash.composeapp.generated.resources.home_title
import scribbledash.composeapp.generated.resources.one_round_wonder
import scribbledash.composeapp.generated.resources.scribble_dash

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    HomeScreen(
        modifier = modifier,
        onOneRoundWonderClick = viewModel::onOneRoundWonderClick,
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    onOneRoundWonderClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            HomeTopAppBar()
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Heading(
                modifier = Modifier
                    .padding(top = 83.dp)
            )
            GameModeCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp
                    ),
                mode = stringResource(Res.string.one_round_wonder),
                icon = Res.drawable.one_round_wonder,
                onClick = onOneRoundWonderClick,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = {
            Text(
                text = stringResource(Res.string.scribble_dash),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )
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
            text = stringResource(Res.string.home_title),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(Res.string.home_sub_title),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackgroundVariant,
        )
    }
}

@Composable
private fun GameModeCard(
    modifier: Modifier = Modifier,
    mode: String,
    icon: DrawableResource,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
            .background(MaterialTheme.colorScheme.success)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceHigh),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 22.dp)
                    .weight(1f),
                text = mode,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Icon(
                painter = painterResource(resource = icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}