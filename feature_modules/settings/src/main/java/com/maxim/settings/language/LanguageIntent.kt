package com.maxim.settings.language

import com.maxim.settings.model.AppLanguageUi

sealed interface LanguageIntent {

    data object OnSaveButtonClick : LanguageIntent

    data class OnLanguageClick(val language: AppLanguageUi) : LanguageIntent
}