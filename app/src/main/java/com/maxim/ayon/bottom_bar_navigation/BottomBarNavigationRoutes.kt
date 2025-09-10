

package com.maxim.ayon.bottom_bar_navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maxim.ayon.R
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomBarScreen(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
) {
    @Serializable
    data object Home : BottomBarScreen(
        icon = R.drawable.ic_home,
        title = R.string.home
    )

    @Serializable
    data object Run : BottomBarScreen(
        icon = R.drawable.ic_run,
        title = R.string.run
    )

    @Serializable
    data object Settings : BottomBarScreen(
        icon = R.drawable.ic_settings,
        title = R.string.settings
    )
}

val bottomBarItems = listOf<BottomBarScreen>(
    BottomBarScreen.Home,
    BottomBarScreen.Run,
    BottomBarScreen.Settings
)
