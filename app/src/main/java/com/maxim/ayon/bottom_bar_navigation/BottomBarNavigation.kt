package com.maxim.ayon.bottom_bar_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maxim.ayon.di.AppComponent
import com.maxim.home.ui.HomeScreen
import com.maxim.navigation.BottomBarNavigationRoute
import com.maxim.navigation.bottomBarItems
import com.maxim.profile.profile_screen.ProfileScreen
import com.maxim.ui.icon.AyonIcons

@Composable
fun BottomBarNavigation(
    appComponent: AppComponent,
    navigateRunScreen: () -> Unit,
    navigateSettingsScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        topBar = {
            AyonTopAppBar(
                currentRoute = currentDestination.routeOrNull,
                onSettingsIconClick = { navigateSettingsScreen() }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = BottomAppBarDefaults.containerColor.copy(alpha = 0.7f)
            ) {
                bottomBarItems.forEachIndexed { index, destination ->
                    AyonNavigationBarItem(
                        currentDestination = currentDestination,
                        destination = destination,
                        onClick = {
                            when (destination) {
                                BottomBarNavigationRoute.Run -> navigateRunScreen()
                                else -> {
                                    navController.navigate(destination) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomBarNavigationRoute.Home
            ) {
                composable<BottomBarNavigationRoute.Home> {
                    HomeScreen()
                }

                composable<BottomBarNavigationRoute.Profile> {
                    ProfileScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AyonTopAppBar(
    currentRoute: String?,
    onSettingsIconClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Title") },
        actions = {
            if (currentRoute == BottomBarNavigationRoute.Profile::class.qualifiedName) {
                IconButton(onClick = onSettingsIconClick) {
                    Icon(
                        imageVector = AyonIcons.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        },
    )
}

@Composable
private fun RowScope.AyonNavigationBarItem(
    currentDestination: NavDestination?,
    destination: BottomBarNavigationRoute,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any { it.route == destination::class.qualifiedName } == true,
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

private val NavDestination?.routeOrNull: String?
    get() = this?.hierarchy?.firstOrNull()?.route