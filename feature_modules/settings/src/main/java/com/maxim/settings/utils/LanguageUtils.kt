package com.maxim.settings.utils

import com.maxim.settings.R
import com.maxim.settings.model.AppLanguageUi
import kotlinx.collections.immutable.persistentListOf

internal fun AppLanguageUi.displayNameRes() =
    when (this) {
        AppLanguageUi.SYSTEM -> R.string.language_system
        AppLanguageUi.ENGLISH -> R.string.language_english
        AppLanguageUi.SPANISH -> R.string.language_spanish
        AppLanguageUi.CHINESE -> R.string.language_chinese
        AppLanguageUi.PORTUGUESE -> R.string.language_portuguese
        AppLanguageUi.RUSSIAN -> R.string.language_russian
    }

internal fun appLanguages() = persistentListOf(
    AppLanguageUi.SYSTEM,
    AppLanguageUi.ENGLISH,
    AppLanguageUi.SPANISH,
    AppLanguageUi.CHINESE,
    AppLanguageUi.PORTUGUESE,
    AppLanguageUi.RUSSIAN,
)