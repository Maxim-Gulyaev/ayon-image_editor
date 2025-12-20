package com.maxim.settings.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.maxim.navigation.RootNavigationRoute
import com.maxim.settings.di.utils.SettingsComponentHolder
import com.maxim.settings.di.utils.SettingsDependencies
import com.maxim.settings.screen.dark_theme_screen.DarkThemeScreen
import com.maxim.settings.screen.dark_theme_screen.DarkThemeViewModel
import com.maxim.settings.screen.language_screen.LanguageScreen
import com.maxim.settings.screen.language_screen.LanguageViewModel
import com.maxim.settings.screen.settings_screen.SettingsScreen


fun NavGraphBuilder.settingsGraph(
    navController: NavController,
    appComponent: SettingsDependencies,
) {
    navigation<RootNavigationRoute.SettingsScreen>(
        startDestination = SettingsNavigationRoute.SettingsScreen
    ) {
        composable<SettingsNavigationRoute.SettingsScreen> {
            SettingsScreen(
                onLanguageClick = {
                    navController.navigate(SettingsNavigationRoute.LanguageScreen)
                },
                onDarkThemeClick = {
                    navController.navigate(SettingsNavigationRoute.DarkThemeScreen)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<SettingsNavigationRoute.LanguageScreen> { entry ->

            // todo дублирование кода убрать, создание компонента поднять на уровень выше

            val settingsComponentHolder: SettingsComponentHolder = viewModel(
                viewModelStoreOwner = entry,
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        @Suppress("UNCHECKED_CAST")
                        return SettingsComponentHolder(appComponent) as T
                    }
                }
            )

            val settingsComponent = settingsComponentHolder.settingsComponent

            val viewModelFactory = settingsComponent.viewModelFactory()

            val languageViewModel: LanguageViewModel =
                viewModel(
                    viewModelStoreOwner = entry,
                    factory = viewModelFactory
                )

            LanguageScreen(
                viewModel = languageViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<SettingsNavigationRoute.DarkThemeScreen> { entry ->

            // todo дублирование кода убрать, создание компонента поднять на уровень выше

            val settingsComponentHolder: SettingsComponentHolder = viewModel(
                viewModelStoreOwner = entry,
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        @Suppress("UNCHECKED_CAST")
                        return SettingsComponentHolder(appComponent) as T
                    }
                }
            )

            val settingsComponent = settingsComponentHolder.settingsComponent

            val viewModelFactory = settingsComponent.viewModelFactory()

            val darkThemeViewModel: DarkThemeViewModel =
                viewModel(
                    viewModelStoreOwner = entry,
                    factory = viewModelFactory
                )

            DarkThemeScreen(
                viewModel = darkThemeViewModel,
                onBackClick = {
                    navController.popBackStack()
                },
            )
        }
    }
}
