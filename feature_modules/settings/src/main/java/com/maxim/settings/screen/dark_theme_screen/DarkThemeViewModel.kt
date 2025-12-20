package com.maxim.settings.screen.dark_theme_screen

import androidx.lifecycle.ViewModel
import com.maxim.common.util.Logger
import com.maxim.model.DarkThemeConfig
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DarkThemeViewModel @Inject constructor(
    private val logger: Logger,
): ViewModel() {

    val uiState = flow {
        emit(
            DarkThemeUiState(
                currentConfig = DarkThemeConfig.DARK,
                loadingStatus = DarkThemeLoadingStatus.Loaded
            )
        )
    }
}