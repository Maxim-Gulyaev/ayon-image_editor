package com.maxim.settings.screen.dark_theme_screen

import com.maxim.model.DarkThemeConfig


data class DarkThemeUiState(
    val darkThemeConfig: DarkThemeConfig,
    val loadingStatus: DarkThemeLoadingStatus,
)

sealed interface DarkThemeLoadingStatus {
    data object Loading : DarkThemeLoadingStatus
    data object Loaded : DarkThemeLoadingStatus
}

