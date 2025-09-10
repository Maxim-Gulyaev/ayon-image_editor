package com.maxim.settings.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsScreen() {

    @Serializable
    data object Main : SettingsScreen()

    @Serializable
    data object Language : SettingsScreen()
}