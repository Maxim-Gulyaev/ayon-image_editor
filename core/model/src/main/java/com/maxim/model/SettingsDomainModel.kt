package com.maxim.model

enum class AppLanguageDomain() {
    SYSTEM,
    ENGLISH,
    SPANISH,
    CHINESE,
    PORTUGUESE,
    RUSSIAN,
}

data class UserPreferencesDomain(
    val appLanguage: AppLanguageDomain,
)