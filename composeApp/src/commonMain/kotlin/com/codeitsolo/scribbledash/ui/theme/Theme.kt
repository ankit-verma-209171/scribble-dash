package com.codeitsolo.scribbledash.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.codeitsolo.scribbledash.ui.theme.color.LocalExtendedColorScheme
import com.codeitsolo.scribbledash.ui.theme.color.extendedLightScheme
import com.codeitsolo.scribbledash.ui.theme.color.lightScheme
import com.codeitsolo.scribbledash.ui.theme.type.AppTypography

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = lightScheme
    val extendedColorScheme = extendedLightScheme

    CompositionLocalProvider(
        LocalExtendedColorScheme provides extendedColorScheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}
