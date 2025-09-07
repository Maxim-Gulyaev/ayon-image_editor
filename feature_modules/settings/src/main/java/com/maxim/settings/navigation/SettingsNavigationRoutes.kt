package com.maxim.settings.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsScreen: NavKey {

    @Serializable
    data object Main : SettingsScreen()

    @Serializable
    data object Language : SettingsScreen()
}