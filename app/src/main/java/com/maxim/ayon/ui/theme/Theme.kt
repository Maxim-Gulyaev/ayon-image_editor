package com.maxim.ayon.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    surfaceDim = SurfaceDimDark,
    surfaceContainerLow = SurfContainerLowDark,
    surfaceContainerLowest = SurfContainerLowestDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceContainer = SurfContainerDark,
    surfaceContainerHigh = SurfContainerHighDark,
    surfaceContainerHighest = SurfContainerHighestDark,
    outline = OutlineDark,
    outlineVariant = OutlineVariantDark,
    tertiary = TertiaryDark,
    onTertiary = OnTertiaryDark,
    surfaceBright = SurfaceBrightDark,
    background = BackgroundDark,
    error = ErrorDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    onError = OnErrorDark,
    onBackground = OnBackgroundDark,
    inverseOnSurface = InverseOnSurfaceDark,
)

val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    surfaceDim = SurfaceDimLight,
    surfaceContainerLow = SurfContainerLowLight,
    surfaceContainerLowest = SurfContainerLowestLight,
    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceContainer = SurfContainerLight,
    surfaceContainerHigh = SurfContainerHighLight,
    surfaceContainerHighest = SurfContainerHighestLight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,
    tertiary = TertiaryLight,
    onTertiary = OnTertiaryLight,
    surfaceBright = SurfaceBrightLight,
    background = BackgroundLight,
    error = ErrorLight,
    onError = OnErrorLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    onBackground = OnBackgroundLight,
    inverseOnSurface = InverseOnSurfaceLight,
)

@Composable
fun AyonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}