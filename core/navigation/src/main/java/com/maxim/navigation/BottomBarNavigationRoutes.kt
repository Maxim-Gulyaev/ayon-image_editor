package com.maxim.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomBarNavigationRoute(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
) {
    @Serializable
    data object Home : BottomBarNavigationRoute(
        icon = R.drawable.ic_home,
        title = R.string.home
    )

    @Serializable
    data object Run : BottomBarNavigationRoute(
        icon = R.drawable.ic_run,
        title = R.string.run
    )

    @Serializable
    data object Profile : BottomBarNavigationRoute(
        icon = R.drawable.ic_profile,
        title = R.string.profile
    )
}

val bottomBarItems = listOf(
    BottomBarNavigationRoute.Home,
    BottomBarNavigationRoute.Run,
    BottomBarNavigationRoute.Profile
)
