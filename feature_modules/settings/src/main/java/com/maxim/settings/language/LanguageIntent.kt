package com.maxim.settings.language

sealed interface LanguageIntent {

    data class OnLanguageClick(val language: Language) : LanguageIntent
}