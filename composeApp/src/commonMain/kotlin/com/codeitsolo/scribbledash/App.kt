package com.codeitsolo.scribbledash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.util.fastForEach
import com.codeitsolo.scribbledash.ui.theme.AppTheme
import com.codeitsolo.scribbledash.ui.theme.color.onBackgroundVariant
import com.codeitsolo.scribbledash.ui.theme.color.success
import com.codeitsolo.scribbledash.ui.theme.color.surfaceHigh
import com.codeitsolo.scribbledash.ui.theme.color.surfaceLowest
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.home_sub_title
import scribbledash.composeapp.generated.resources.home_title
import scribbledash.composeapp.generated.resources.ic_chart
import scribbledash.composeapp.generated.resources.ic_home
import scribbledash.composeapp.generated.resources.one_round_wonder
import scribbledash.composeapp.generated.resources.scribble_dash

enum class ScribbleDashTab(val icon: DrawableResource) {
    Chart(icon = Res.drawable.ic_chart),
    Home(icon = Res.drawable.ic_home),
}

@Composable
fun App() {
    AppTheme {
        Scaffold(
            topBar = {
                HomeTopAppBar()
            },
            bottomBar = {
                ScribbleBottomAppBar(
                    selectedTab = ScribbleDashTab.Home,
                    onTabClick = {}
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
                    onClick = {}
                )
            }
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
private fun ScribbleBottomAppBar(
    modifier: Modifier = Modifier,
    selectedTab: ScribbleDashTab,
    onTabClick: (ScribbleDashTab) -> Unit,
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceHigh,
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ScribbleDashTab.entries.fastForEach {
                    IconButton(onClick = { onTabClick(it) }) {
                        Icon(
                            modifier = Modifier
                                .size(32.dp),
                            painter = painterResource(it.icon),
                            contentDescription = null,
                            tint = if (it == selectedTab) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.surfaceLowest
                            },
                        )
                    }
                }
            }
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