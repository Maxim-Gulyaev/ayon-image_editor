package com.maxim.settings.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.maxim.navigation.BottomBarScreen
import com.maxim.settings.di.SettingsComponentHolder
import com.maxim.settings.di.SettingsDependencies
import com.maxim.settings.language.LanguageScreen
import com.maxim.settings.language.LanguageViewModel
import com.maxim.settings.main_screen.SettingsScreen


fun NavGraphBuilder.settingsGraph(
    navController: NavController,
    appComponent: SettingsDependencies,
) {
    navigation<BottomBarScreen.Settings>(
        startDestination = SettingsScreen.Main
    ) {
        composable<SettingsScreen.Main> {
            SettingsScreen(
                onLanguageClick = {
                    navController.navigate(SettingsScreen.Language)
                }
            )
        }
        composable<SettingsScreen.Language> { entry ->

            val settingsComponentHolder: SettingsComponentHolder = viewModel(
                viewModelStoreOwner = entry,
                factory = object : androidx.lifecycle.ViewModelProvider.Factory {
                    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
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
                viewModel = languageViewModel
            )
        }
    }
}
