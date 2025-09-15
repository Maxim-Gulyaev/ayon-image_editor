package com.maxim.settings.language

import androidx.compose.runtime.Immutable
import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.utils.appLanguages
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class LanguageUiState(
    val appLanguages: ImmutableList<AppLanguageUi>,
    val currentAppLanguage: AppLanguageUi,
) {
    companion object {
        val initial = LanguageUiState(
            appLanguages = appLanguages,
            currentAppLanguage = AppLanguageUi.SYSTEM,
        )
    }
}
