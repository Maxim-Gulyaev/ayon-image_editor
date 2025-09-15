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