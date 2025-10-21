package com.maxim.datastore.model

import com.maxim.model.AppLanguage

enum class AppLanguageEntity() {
    SYSTEM,
    ENGLISH,
    SPANISH,
    CHINESE,
    PORTUGUESE,
    RUSSIAN,
}

fun AppLanguageEntity.toDomain() =
    when (this) {
        AppLanguageEntity.SYSTEM -> AppLanguage.SYSTEM
        AppLanguageEntity.ENGLISH -> AppLanguage.ENGLISH
        AppLanguageEntity.SPANISH -> AppLanguage.SPANISH
        AppLanguageEntity.CHINESE -> AppLanguage.CHINESE
        AppLanguageEntity.PORTUGUESE -> AppLanguage.PORTUGUESE
        AppLanguageEntity.RUSSIAN -> AppLanguage.RUSSIAN
    }

fun AppLanguage.toData() =
    when (this) {
        AppLanguage.SYSTEM -> AppLanguageEntity.SYSTEM
        AppLanguage.ENGLISH -> AppLanguageEntity.ENGLISH
        AppLanguage.SPANISH -> AppLanguageEntity.SPANISH
        AppLanguage.CHINESE -> AppLanguageEntity.CHINESE
        AppLanguage.PORTUGUESE -> AppLanguageEntity.PORTUGUESE
        AppLanguage.RUSSIAN -> AppLanguageEntity.RUSSIAN
    }