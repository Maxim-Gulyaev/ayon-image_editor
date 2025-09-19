package com.maxim.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomBarNavRoute(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
) {
    @Serializable
    data object Home : BottomBarNavRoute(
        icon = R.drawable.ic_home,
        title = R.string.home
    )

    @Serializable
    data object Run : BottomBarNavRoute(
        icon = R.drawable.ic_run,
        title = R.string.run
    )

    @Serializable
    data object Settings : BottomBarNavRoute(
        icon = R.drawable.ic_settings,
        title = R.string.settings
    )
}

val bottomBarItems = listOf<BottomBarNavRoute>(
    BottomBarNavRoute.Home,
    BottomBarNavRoute.Run,
    BottomBarNavRoute.Settings
)
