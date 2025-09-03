package com.maxim.ayon.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.maxim.home.ui.HomeScreen
import com.maxim.ui.R

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(Home)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .paint(
                painterResource(R.drawable.main_background),
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            ),
    ) {
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
                    HomeScreen()
                }
            }
        )
    }
}