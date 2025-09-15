package com.maxim.settings.language

import com.maxim.settings.model.AppLanguageUi

sealed interface LanguageIntent {

    data class OnLanguageClick(val appLanguage: AppLanguageUi) : LanguageIntent
}