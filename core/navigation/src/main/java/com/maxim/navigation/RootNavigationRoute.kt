package com.maxim.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class RootNavigationRoute {

    @Serializable
    data object BottomBarScreen : RootNavigationRoute()

    @Serializable
    data object SettingsScreen : RootNavigationRoute()

    @Serializable
    data object RunScreen : RootNavigationRoute()
}