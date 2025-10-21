package com.maxim.settings.model

import com.maxim.model.AppLanguage

enum class AppLanguageUiModel(val tag: String) {
    SYSTEM(""),
    ENGLISH("en"),
    SPANISH("es"),
    CHINESE("zh"),
    PORTUGUESE("pt"),
    RUSSIAN("ru");
}

fun AppLanguage.toUi() =
    when (this) {
        AppLanguage.SYSTEM -> AppLanguageUiModel.SYSTEM
        AppLanguage.ENGLISH -> AppLanguageUiModel.ENGLISH
        AppLanguage.SPANISH -> AppLanguageUiModel.SPANISH
        AppLanguage.CHINESE -> AppLanguageUiModel.CHINESE
        AppLanguage.PORTUGUESE -> AppLanguageUiModel.PORTUGUESE
        AppLanguage.RUSSIAN -> AppLanguageUiModel.RUSSIAN
    }

fun AppLanguageUiModel.toDomain() =
    when (this) {
        AppLanguageUiModel.SYSTEM -> AppLanguage.SYSTEM
        AppLanguageUiModel.ENGLISH -> AppLanguage.ENGLISH
        AppLanguageUiModel.SPANISH -> AppLanguage.SPANISH
        AppLanguageUiModel.CHINESE -> AppLanguage.CHINESE
        AppLanguageUiModel.PORTUGUESE -> AppLanguage.PORTUGUESE
        AppLanguageUiModel.RUSSIAN -> AppLanguage.RUSSIAN
    }