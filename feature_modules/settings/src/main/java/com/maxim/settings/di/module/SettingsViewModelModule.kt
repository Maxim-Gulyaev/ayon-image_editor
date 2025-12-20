package com.maxim.settings.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxim.common.di.AyonViewModelFactory
import com.maxim.common.di.ViewModelKey
import com.maxim.settings.di.utils.SettingsScope
import com.maxim.settings.screen.dark_theme_screen.DarkThemeViewModel
import com.maxim.settings.screen.language_screen.LanguageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SettingsViewModelModule {

    @SettingsScope
    @Binds
    abstract fun bindViewModelFactory(factory: AyonViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LanguageViewModel::class)
    abstract fun bindLanguageViewModel(viewModel: LanguageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DarkThemeViewModel::class)
    abstract fun bindDarkThemeViewModel(viewModel: DarkThemeViewModel): ViewModel
}