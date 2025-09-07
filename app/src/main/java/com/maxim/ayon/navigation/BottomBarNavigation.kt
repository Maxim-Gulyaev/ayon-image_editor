package com.maxim.ayon.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.maxim.home.ui.HomeScreen
import com.maxim.settings.main_screen.SettingsScreen
import com.maxim.ui.components.BackgroundContainer

@Composable
fun BottomBarNavigation(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(BottomBarScreen.Home)

    var currentBottomBarScreen: BottomBarScreen by rememberSaveable(
        stateSaver = BottomBarScreenSaver
    ) { mutableStateOf(BottomBarScreen.Home) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = BottomAppBarDefaults.containerColor.copy(alpha = 0.7f)
            ) {
                bottomBarItems.forEach { destination ->
                    AyonNavigationBarItem(
                        currentBottomBarScreen = currentBottomBarScreen,
                        destination = destination,
                        onClick = {
                            if (backStack.lastOrNull() != destination) {
                                if (backStack.lastOrNull() in bottomBarItems) {
                                    backStack.removeAt(backStack.lastIndex)
                                }
                                backStack.add(destination)
                                currentBottomBarScreen = destination
                            }
                        },
                    )
                }
            }
        }
    ) { paddingValues ->
        BackgroundContainer(
            modifier = modifier.padding(paddingValues)
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
                    entry<BottomBarScreen.Home> {
                        HomeScreen()
                    }
                    entry<BottomBarScreen.Run> {
                        Box(
                            modifier = modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) { Text(text = "Not implemented Run screen") }
                    }
                    entry<BottomBarScreen.Settings> {
                        SettingsScreen()
                    }
                }
            )
        }
    }
}

@Composable
private fun RowScope.AyonNavigationBarItem(
    currentBottomBarScreen: BottomBarScreen,
    destination: BottomBarScreen,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        selected = currentBottomBarScreen == destination,
        icon = {
            Icon(
                painter = painterResource(destination.icon),
                contentDescription = "$destination icon"
            )
        },
        onClick = onClick,
        label = {
            Text(text = stringResource(destination.title))
        },
        colors = NavigationBarItemDefaults.colors(
            selectedTextColor = MaterialTheme.colorScheme.onSecondary,
            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
            indicatorColor = MaterialTheme.colorScheme.tertiary
        )
    )
}