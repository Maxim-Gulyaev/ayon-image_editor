package com.maxim.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.maxim.ui.R

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
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .paint(
                        painterResource(R.drawable.main_background),
                        contentScale = ContentScale.FillBounds,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                    ),
            ) {
                content()
            }
        }
    )
}