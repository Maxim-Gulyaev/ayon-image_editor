package com.maxim.settings.language

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class LanguageUiState(
    val languages: ImmutableList<Language>,
    val currentLanguage: Language,
) {
    companion object {
        val initial = LanguageUiState(
            languages = persistentListOf(
                Language.SYSTEM,
                Language.ENGLISH,
                Language.SPANISH,
                Language.CHINESE,
                Language.PORTUGUESE,
            ),
            currentLanguage = Language.SYSTEM,
        )
    }
}

enum class Language {
    SYSTEM,
    ENGLISH,
    SPANISH,
    CHINESE,
    PORTUGUESE,
}