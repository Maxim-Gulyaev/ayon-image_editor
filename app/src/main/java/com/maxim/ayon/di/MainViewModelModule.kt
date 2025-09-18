package com.maxim.ayon.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxim.ayon.MainViewModel
import com.maxim.common.AyonViewModelFactory
import com.maxim.settings.di.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class MainViewModelModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: AyonViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindLanguageViewModel(viewModel: MainViewModel): ViewModel
}