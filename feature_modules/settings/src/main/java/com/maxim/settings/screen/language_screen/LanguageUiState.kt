package com.maxim.settings.screen.language_screen

import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.utils.appLanguages
import kotlinx.collections.immutable.ImmutableList

sealed interface LanguageUiState {

    data class Success(
        val appLanguages: ImmutableList<AppLanguageUi> = appLanguages(),
        val currentAppLanguage: AppLanguageUi = AppLanguageUi.SYSTEM,
        val selectedLanguage: AppLanguageUi = AppLanguageUi.SYSTEM,
    ) : LanguageUiState

    data class Error(val throwable: Throwable) : LanguageUiState

    data object Loading : LanguageUiState
}