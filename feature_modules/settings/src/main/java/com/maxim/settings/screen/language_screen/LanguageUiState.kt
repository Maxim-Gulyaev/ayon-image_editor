package com.maxim.settings.screen.language_screen

import androidx.compose.runtime.Immutable
import com.maxim.settings.model.AppLanguageUiModel
import com.maxim.settings.utils.appLanguages
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class LanguageUiState(
    val appLanguages: ImmutableList<AppLanguageUiModel>,
    val currentAppLanguage: AppLanguageUiModel,
    val selectedLanguage: AppLanguageUiModel,
) {
    companion object {
        val initial = LanguageUiState(
            appLanguages = appLanguages,
            currentAppLanguage = AppLanguageUiModel.SYSTEM,
            selectedLanguage = AppLanguageUiModel.SYSTEM,
        )
    }
}
