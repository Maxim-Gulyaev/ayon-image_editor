package com.maxim.ayon.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
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
            entry<Home> {

            }
        }
    )
}