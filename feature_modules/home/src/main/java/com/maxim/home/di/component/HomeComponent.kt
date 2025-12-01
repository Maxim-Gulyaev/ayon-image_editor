package com.maxim.home.di.component

import androidx.lifecycle.ViewModelProvider
import com.maxim.home.di.module.HomeViewModelModule
import com.maxim.home.di.utils.HomeDependencies
import com.maxim.home.di.utils.HomeScope
import dagger.Component

@HomeScope
@Component(
    dependencies = [HomeDependencies::class],
    modules = [
        HomeViewModelModule::class
    ]
)
interface HomeComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeDependencies): HomeComponent
    }
}