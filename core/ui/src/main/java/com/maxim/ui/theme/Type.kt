package com.maxim.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.maxim.ui.R

val AyonFontFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.roboto_black_italic, FontWeight.Black, FontStyle.Italic),

    Font(R.font.roboto_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.roboto_bold_italic, FontWeight.Bold, FontStyle.Italic),

    Font(R.font.roboto_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.roboto_medium_italic, FontWeight.Medium, FontStyle.Italic),

    Font(R.font.roboto_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),

    Font(R.font.roboto_light, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.roboto_light_italic, FontWeight.Light, FontStyle.Italic),

    Font(R.font.roboto_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic)
)

val AyonTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AyonFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = AyonFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AyonFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = AyonFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = AyonFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
)