package com.maxim.settings.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.maxim.navigation.BottomBarScreen
import com.maxim.settings.language.LanguageScreen
import com.maxim.settings.language.LanguageViewModel
import com.maxim.settings.main_screen.SettingsScreen


fun NavGraphBuilder.settingsGraph(navController: NavController) {
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
        composable<SettingsScreen.Language> {
            LanguageScreen(
                viewModel = viewModel<LanguageViewModel>()
            )
        }
    }
}
