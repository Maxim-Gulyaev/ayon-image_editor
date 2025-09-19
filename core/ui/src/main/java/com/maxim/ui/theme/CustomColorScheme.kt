package com.maxim.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorScheme(
    val positiveGreen: Color = Color.Unspecified,
    val onPositiveGreen: Color = Color.Unspecified,
    val cautionOrange: Color = Color.Unspecified,
    val onCautionOrange: Color = Color.Unspecified,
)


val LocalCustomColorScheme = staticCompositionLocalOf { CustomColorScheme() }


val OnLightCustomColorScheme = CustomColorScheme(
    positiveGreen = Color(color = 0xFF65B77A),
    onPositiveGreen = Color(color = 0xFFFFFFFF),
    cautionOrange = Color(color = 0xFFF2AC29),
    onCautionOrange = Color(color = 0xFFFFFFFF)
)


val OnDarkCustomColorScheme = CustomColorScheme(
    positiveGreen = Color(color = 0xFF3ACB74),
    onPositiveGreen = Color(color = 0xFFFFFFFF),
    cautionOrange = Color(color = 0xFFF1B33B),
    onCautionOrange = Color(color = 0xFFFFFFFF)
)