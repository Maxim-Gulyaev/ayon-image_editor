/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:OptIn(ExperimentalSerializationApi::class)

package com.maxim.ayon.bottom_bar_navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import com.maxim.ayon.R
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomBarScreen(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
): NavKey {
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

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
    save = { it::class.simpleName ?: "Unknown" },
    restore = {
        when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Run::class.simpleName -> BottomBarScreen.Run
            BottomBarScreen.Settings::class.simpleName -> BottomBarScreen.Settings
            else -> BottomBarScreen.Home
        }
    }
)
