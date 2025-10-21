package com.maxim.settings.utils

import com.maxim.settings.R
import com.maxim.settings.model.AppLanguageUiModel
import kotlinx.collections.immutable.persistentListOf

internal fun AppLanguageUiModel.displayNameRes() =
    when (this) {
        AppLanguageUiModel.SYSTEM -> R.string.language_system
        AppLanguageUiModel.ENGLISH -> R.string.language_english
        AppLanguageUiModel.SPANISH -> R.string.language_spanish
        AppLanguageUiModel.CHINESE -> R.string.language_chinese
        AppLanguageUiModel.PORTUGUESE -> R.string.language_portuguese
        AppLanguageUiModel.RUSSIAN -> R.string.language_russian
    }

internal val appLanguages = persistentListOf(
    AppLanguageUiModel.SYSTEM,
    AppLanguageUiModel.ENGLISH,
    AppLanguageUiModel.SPANISH,
    AppLanguageUiModel.CHINESE,
    AppLanguageUiModel.PORTUGUESE,
    AppLanguageUiModel.RUSSIAN,
)