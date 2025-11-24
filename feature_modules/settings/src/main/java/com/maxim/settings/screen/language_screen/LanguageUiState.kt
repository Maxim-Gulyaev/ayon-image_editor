package com.maxim.settings.screen.language_screen

import androidx.compose.runtime.Immutable
import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.utils.appLanguages
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class LanguageUiState(
    val appLanguages: ImmutableList<AppLanguageUi>,
    val currentAppLanguage: AppLanguageUi,
    val selectedLanguage: AppLanguageUi,
) {
    companion object {
        fun initial() = LanguageUiState(
            appLanguages = appLanguages(),
            currentAppLanguage = AppLanguageUi.SYSTEM,
            selectedLanguage = AppLanguageUi.SYSTEM,
        )
    }
}
