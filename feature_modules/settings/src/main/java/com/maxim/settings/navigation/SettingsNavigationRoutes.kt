package com.maxim.settings.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsScreen: NavKey {

    @Serializable
    data object MainScreen : SettingsScreen()

    @Serializable
    data object LanguageScreen : SettingsScreen()
}