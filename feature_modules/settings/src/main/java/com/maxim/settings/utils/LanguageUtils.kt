package com.maxim.settings.utils

import com.maxim.settings.R
import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.model.AppLanguageUi.CHINESE
import com.maxim.settings.model.AppLanguageUi.ENGLISH
import com.maxim.settings.model.AppLanguageUi.PORTUGUESE
import com.maxim.settings.model.AppLanguageUi.RUSSIAN
import com.maxim.settings.model.AppLanguageUi.SPANISH
import com.maxim.settings.model.AppLanguageUi.SYSTEM
import kotlinx.collections.immutable.persistentListOf

internal fun AppLanguageUi.displayNameRes() =
    when (this) {
        SYSTEM -> R.string.language_system
        ENGLISH -> R.string.language_english
        SPANISH -> R.string.language_spanish
        CHINESE -> R.string.language_chinese
        PORTUGUESE -> R.string.language_portuguese
        RUSSIAN -> R.string.language_russian
    }

internal val appLanguages = persistentListOf(
    SYSTEM,
    ENGLISH,
    SPANISH,
    CHINESE,
    PORTUGUESE,
    RUSSIAN,
)