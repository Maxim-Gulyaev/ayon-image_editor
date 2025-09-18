package theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorScheme(
    val positively: Color = Color.Unspecified,
    val onPositively: Color = Color.Unspecified,
    val processing: Color = Color.Unspecified,
    val onProcessing: Color = Color.Unspecified,
)


val LocalCustomColorScheme = staticCompositionLocalOf { CustomColorScheme() }


val OnLightCustomColorScheme = CustomColorScheme(
    positively = Color(color = 0xFF65B77A),
    onPositively = Color(color = 0xFFFFFFFF),
    processing = Color(color = 0xFFF2AC29),
    onProcessing = Color(color = 0xFFFFFFFF)
)


val OnDarkCustomColorScheme = CustomColorScheme(
    positively = Color(color = 0xFF3ACB74),
    onPositively = Color(color = 0xFFFFFFFF),
    processing = Color(color = 0xFFF1B33B),
    onProcessing = Color(color = 0xFFFFFFFF)
)