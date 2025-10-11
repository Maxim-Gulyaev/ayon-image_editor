package com.maxim.home.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxim.common.di.AyonViewModelFactory
import com.maxim.common.di.ViewModelKey
import com.maxim.home.di.utils.HomeScope
import com.maxim.home.screen.home_screen.HomeScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @HomeScope
    @Binds
    abstract fun bindViewModelFactory(factory: AyonViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenViewModel::class)
    abstract fun bindLanguageViewModel(viewModel: HomeScreenViewModel): ViewModel
}