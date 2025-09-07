package com.maxim.settings.language

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.maxim.settings.R
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class LanguageUiState(
    val languages: ImmutableList<Language>,
    val currentLanguage: Language,
) {
    companion object {
        val initial = LanguageUiState(
            languages = Language.languages,
            currentLanguage = Language.SYSTEM,
        )
    }
}

enum class Language(@StringRes val displayNameRes: Int) {
    SYSTEM(R.string.language_system),
    ENGLISH(R.string.language_english),
    SPANISH(R.string.language_spanish),
    CHINESE(R.string.language_chinese),
    PORTUGUESE(R.string.language_portuguese);

    companion object {
        val languages = persistentListOf(
            SYSTEM,
            ENGLISH,
            SPANISH,
            CHINESE,
            PORTUGUESE,
        )
    }
}
