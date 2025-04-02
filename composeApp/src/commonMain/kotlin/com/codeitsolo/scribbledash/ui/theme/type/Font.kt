package com.codeitsolo.scribbledash.ui.theme.type

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import scribbledash.composeapp.generated.resources.Res
import scribbledash.composeapp.generated.resources.bagel_fat_one_regular
import scribbledash.composeapp.generated.resources.outfit_medium
import scribbledash.composeapp.generated.resources.outfit_regular
import scribbledash.composeapp.generated.resources.outfit_semibold

val bodyFontFamily
    @Composable
    get() = FontFamily(
        Font(resource = Res.font.outfit_regular, weight = FontWeight.Normal),
        Font(resource = Res.font.outfit_medium, weight = FontWeight.Medium),
        Font(resource = Res.font.outfit_semibold, weight = FontWeight.SemiBold),
    )

val displayFontFamily
    @Composable
    get() = FontFamily(
        Font(resource = Res.font.bagel_fat_one_regular, weight = FontWeight.Normal)
    )