package com.codeitsolo.scribbledash.ui.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val lightScheme = lightColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,

    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,

    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,

    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,

    background = background,
    onBackground = onBackground,

    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,

    surfaceTint = surfaceTint,
    outline = outline,

    surfaceContainerLow = surfaceLow,
    surfaceContainerHigh = surfaceHigh,
    surfaceContainerLowest = surfaceLowest,
)

val ColorScheme.onBackgroundVariant: Color
    get() = backgroundVariant

val ColorScheme.surfaceHigh: Color
    get() = surfaceContainerHigh

val ColorScheme.success: Color
    get() = com.codeitsolo.scribbledash.ui.theme.color.success

val ColorScheme.onSuccess: Color
    get() = com.codeitsolo.scribbledash.ui.theme.color.onSuccess

val ColorScheme.surfaceLowest: Color
    get() = surfaceContainerLowest