package com.maxim.settings.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.maxim.settings.language.LanguageScreen
import com.maxim.settings.language.LanguageViewModel
import com.maxim.settings.main_screen.SettingsScreen

@Composable
fun SettingsNavigation(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(SettingsScreen.Main)
    val stateHolder = rememberSaveableStateHolder()

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberViewModelStoreNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
        ),
        transitionSpec = {
            ContentTransform(
                fadeIn(),
                fadeOut(),
            )
        },
        popTransitionSpec = {
            ContentTransform(
                fadeIn(),
                scaleOut(
                    targetScale = 0.7f,
                ),
            )
        },
        entryProvider = entryProvider {
            entry<SettingsScreen.Main> {
                SettingsScreen(
                    onLanguageClick = { backStack.add(SettingsScreen.Language) }
                )
            }
            entry<SettingsScreen.Language> {
                stateHolder.SaveableStateProvider(it.toString()) {
                    val viewModel: LanguageViewModel  = viewModel()
                    LanguageScreen(
                        viewModel = viewModel
                    )
                }
            }
        }
    )
}