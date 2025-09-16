package com.maxim.domain.model.settings

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