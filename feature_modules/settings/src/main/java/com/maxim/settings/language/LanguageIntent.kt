package com.maxim.settings.language

import com.maxim.model.AppLanguage

sealed interface LanguageIntent {

    data class OnLanguageClick(val appLanguage: AppLanguage) : LanguageIntent
}