package com.maxim.settings.screen.dark_theme_screen

import com.maxim.model.DarkThemeConfig

sealed interface DarkThemeScreenIntent {

    data class OnOptionClicked(
        val config: DarkThemeConfig
    ) : DarkThemeScreenIntent
}

