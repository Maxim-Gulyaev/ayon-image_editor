package com.maxim.data.mapper

import com.maxim.domain.model.settings.AppLanguageDomain
import com.maxim.model.AppLanguage

fun AppLanguage.toDomain() =
    when (this) {
        AppLanguage.SYSTEM -> AppLanguageDomain.SYSTEM
        AppLanguage.ENGLISH -> AppLanguageDomain.ENGLISH
        AppLanguage.SPANISH -> AppLanguageDomain.SPANISH
        AppLanguage.CHINESE -> AppLanguageDomain.CHINESE
        AppLanguage.PORTUGUESE -> AppLanguageDomain.PORTUGUESE
    }

fun AppLanguageDomain.toData() =
    when (this) {
        AppLanguageDomain.SYSTEM -> AppLanguage.SYSTEM
        AppLanguageDomain.ENGLISH -> AppLanguage.ENGLISH
        AppLanguageDomain.SPANISH -> AppLanguage.SPANISH
        AppLanguageDomain.CHINESE -> AppLanguage.CHINESE
        AppLanguageDomain.PORTUGUESE -> AppLanguage.PORTUGUESE
    }