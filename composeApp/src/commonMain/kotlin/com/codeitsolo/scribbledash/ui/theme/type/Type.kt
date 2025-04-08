package com.codeitsolo.scribbledash.ui.theme.type

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val baseline = Typography()

val AppTypography
    @Composable
    get() = Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily).copy(
            fontSize = 66.sp,
            lineHeight = 80.sp,
            fontWeight = FontWeight.Normal,
        ),
        displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily).copy(
            fontSize = 40.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Normal,
        ),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily).copy(
            fontSize = 34.sp,
            lineHeight = 48.sp,
            fontWeight = FontWeight.Normal,
        ),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily).copy(
            fontSize = 26.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight.Normal,
        ),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily).copy(
            fontSize = 18.sp,
            lineHeight = 26.sp,
            fontWeight = FontWeight.Normal,
        ),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily).copy(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
        ),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily).copy(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal,
        ),
        bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily).copy(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Normal,
        ),
        labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily).copy(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.SemiBold,
        ),
        labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily).copy(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
        ),
        labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily).copy(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.SemiBold,
        ),
    )

val Typography.headingExtraSmall
    get() = baseline.headlineSmall.copy(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal
    )

val Typography.labelExtraLarge
    get() = baseline.labelLarge.copy(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold
    )