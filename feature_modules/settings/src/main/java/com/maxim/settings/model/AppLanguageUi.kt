package com.maxim.settings.model

import com.maxim.model.AppLanguage

enum class AppLanguageUi(val tag: String) {
    SYSTEM(""),
    ENGLISH("en"),
    SPANISH("es"),
    CHINESE("zh"),
    PORTUGUESE("pt"),
    RUSSIAN("ru");
}

fun AppLanguage.toUi() =
    when (this) {
        AppLanguage.SYSTEM -> AppLanguageUi.SYSTEM
        AppLanguage.ENGLISH -> AppLanguageUi.ENGLISH
        AppLanguage.SPANISH -> AppLanguageUi.SPANISH
        AppLanguage.CHINESE -> AppLanguageUi.CHINESE
        AppLanguage.PORTUGUESE -> AppLanguageUi.PORTUGUESE
        AppLanguage.RUSSIAN -> AppLanguageUi.RUSSIAN
    }

fun AppLanguageUi.toDomain() =
    when (this) {
        AppLanguageUi.SYSTEM -> AppLanguage.SYSTEM
        AppLanguageUi.ENGLISH -> AppLanguage.ENGLISH
        AppLanguageUi.SPANISH -> AppLanguage.SPANISH
        AppLanguageUi.CHINESE -> AppLanguage.CHINESE
        AppLanguageUi.PORTUGUESE -> AppLanguage.PORTUGUESE
        AppLanguageUi.RUSSIAN -> AppLanguage.RUSSIAN
    }