package com.maxim.run.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.maxim.navigation.BottomBarNavigationRoute
import com.maxim.run.di.utils.RunComponentHolder
import com.maxim.run.di.utils.RunDependencies
import com.maxim.run.run_screen.RunScreen
import com.maxim.run.run_screen.RunViewModel

fun NavGraphBuilder.runGraph(
    appComponent: RunDependencies,
) {
    navigation<BottomBarNavigationRoute.Run>(
        startDestination = RunNavRoute.RunScreen
    ) {
        composable<RunNavRoute.RunScreen> { entry ->

            val runComponentHolder: RunComponentHolder = viewModel(
                viewModelStoreOwner = entry,
                factory = object : androidx.lifecycle.ViewModelProvider.Factory {
                    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                        @Suppress("UNCHECKED_CAST")
                        return RunComponentHolder(appComponent) as T
                    }
                }
            )

            val runComponent = runComponentHolder.runComponent

            val viewModelFactory = runComponent.viewModelFactory()

            val languageViewModel: RunViewModel =
                viewModel(
                    viewModelStoreOwner = entry,
                    factory = viewModelFactory
                )

            RunScreen(
                viewModel = languageViewModel
            )
        }
    }
}