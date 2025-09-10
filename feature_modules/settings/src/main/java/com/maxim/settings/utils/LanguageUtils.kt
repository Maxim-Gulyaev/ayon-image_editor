package com.maxim.settings.utils

import com.maxim.model.AppLanguage
import com.maxim.model.AppLanguage.CHINESE
import com.maxim.model.AppLanguage.ENGLISH
import com.maxim.model.AppLanguage.PORTUGUESE
import com.maxim.model.AppLanguage.SPANISH
import com.maxim.model.AppLanguage.SYSTEM
import com.maxim.settings.R
import kotlinx.collections.immutable.persistentListOf

internal fun AppLanguage.displayNameRes() =
    when (this) {
        SYSTEM -> R.string.language_system
        ENGLISH -> R.string.language_english
        SPANISH -> R.string.language_spanish
        CHINESE -> R.string.language_chinese
        PORTUGUESE -> R.string.language_portuguese
    }

internal val appLanguages = persistentListOf(
    SYSTEM,
    ENGLISH,
    SPANISH,
    CHINESE,
    PORTUGUESE,
)