package com.maxim.ayon.root_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxim.ayon.bottom_bar_navigation.BottomBarNavigation
import com.maxim.ayon.di.AppComponent
import com.maxim.navigation.RootNavigationRoute
import com.maxim.run.navigation.runGraph
import com.maxim.settings.navigation.settingsGraph

@Composable
fun RootNavigation(
    appComponent: AppComponent,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RootNavigationRoute.BottomBarScreen
    ) {
        composable<RootNavigationRoute.BottomBarScreen> {
            BottomBarNavigation(
                appComponent = appComponent,
                navigateRunScreen = { navController.navigate(RootNavigationRoute.RunScreen) },
                navigateSettingsScreen = { navController.navigate(RootNavigationRoute.SettingsScreen) }
            )
        }

        runGraph(
            appComponent = appComponent,
            quitRunScreen = { navController.popBackStack() }
        )

        settingsGraph(navController, appComponent)
    }
}