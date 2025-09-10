package com.maxim.settings.language

import androidx.compose.runtime.Immutable
import com.maxim.model.AppLanguage
import com.maxim.settings.utils.appLanguages
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class LanguageUiState(
    val appLanguages: ImmutableList<AppLanguage>,
    val currentAppLanguage: AppLanguage,
) {
    companion object {
        val initial = LanguageUiState(
            appLanguages = appLanguages,
            currentAppLanguage = AppLanguage.SYSTEM,
        )
    }
}
