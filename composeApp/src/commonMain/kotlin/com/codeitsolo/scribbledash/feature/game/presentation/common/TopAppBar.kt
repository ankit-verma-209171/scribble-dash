package com.codeitsolo.scribbledash.feature.game.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.ic_back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun GameTopAppBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = {},
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                IconButton(
                    modifier = Modifier
                        .padding(end = 4.dp),
                    onClick = onBackClick
                ) {
                    Icon(
                        modifier = Modifier
                            .size(56.dp),
                        painter = painterResource(Res.drawable.ic_back),
                        contentDescription = "back click"
                    )
                }
            }
        }
    )
}