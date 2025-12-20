package com.maxim.settings.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsNavigationRoute() {

    @Serializable
    data object SettingsScreen : SettingsNavigationRoute()

    @Serializable
    data object LanguageScreen : SettingsNavigationRoute()

    @Serializable
    data object DarkThemeScreen : SettingsNavigationRoute()
}