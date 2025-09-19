package com.maxim.settings.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsNavRoute() {

    @Serializable
    data object SettingsScreen : SettingsNavRoute()

    @Serializable
    data object LanguageScreen : SettingsNavRoute()
}