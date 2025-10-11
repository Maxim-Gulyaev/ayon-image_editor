package com.maxim.settings.model

import com.maxim.model.AppLanguageDomain

fun AppLanguageDomain.toUi() =
    when (this) {
        AppLanguageDomain.SYSTEM -> AppLanguageUi.SYSTEM
        AppLanguageDomain.ENGLISH -> AppLanguageUi.ENGLISH
        AppLanguageDomain.SPANISH -> AppLanguageUi.SPANISH
        AppLanguageDomain.CHINESE -> AppLanguageUi.CHINESE
        AppLanguageDomain.PORTUGUESE -> AppLanguageUi.PORTUGUESE
        AppLanguageDomain.RUSSIAN -> AppLanguageUi.RUSSIAN
    }

fun AppLanguageUi.toDomain() =
    when (this) {
        AppLanguageUi.SYSTEM -> AppLanguageDomain.SYSTEM
        AppLanguageUi.ENGLISH -> AppLanguageDomain.ENGLISH
        AppLanguageUi.SPANISH -> AppLanguageDomain.SPANISH
        AppLanguageUi.CHINESE -> AppLanguageDomain.CHINESE
        AppLanguageUi.PORTUGUESE -> AppLanguageDomain.PORTUGUESE
        AppLanguageUi.RUSSIAN -> AppLanguageDomain.RUSSIAN
    }