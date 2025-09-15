package com.maxim.domain.model.settings

enum class AppLanguageDomain() {
    SYSTEM,
    ENGLISH,
    SPANISH,
    CHINESE,
    PORTUGUESE
}

data class UserPreferencesDomain(
    val appLanguage: AppLanguageDomain,
)