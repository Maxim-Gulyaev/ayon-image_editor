package com.maxim.settings.language_screen

import com.maxim.settings.model.AppLanguageUi

sealed interface LanguageIntent {

    data object OnSaveButtonClick : LanguageIntent

    data class OnLanguageClick(val language: AppLanguageUi) : LanguageIntent
}