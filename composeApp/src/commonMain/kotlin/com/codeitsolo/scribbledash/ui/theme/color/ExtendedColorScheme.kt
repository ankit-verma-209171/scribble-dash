package com.codeitsolo.scribbledash.ui.theme.color

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class ExtendedColorScheme(
    val success: ColorFamily,
)

val extendedLightScheme = ExtendedColorScheme(
    success = ColorFamily(
        success,
        onSuccess,
        successContainer,
        onSuccessContainer,
    ),
)

val LocalExtendedColorScheme = staticCompositionLocalOf { extendedLightScheme }

// Extension property to access extended colors in MaterialTheme
val MaterialTheme.extendedColorScheme: ExtendedColorScheme
    @Composable
    @ReadOnlyComposable
    get() = LocalExtendedColorScheme.current