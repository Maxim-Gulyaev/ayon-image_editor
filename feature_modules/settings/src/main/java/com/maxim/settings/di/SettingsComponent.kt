package com.maxim.settings.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component

@FeatureScope
@Component(
    dependencies = [SettingsDependencies::class],
    modules = [SettingsViewModelModule::class]
)
interface SettingsComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: SettingsDependencies): SettingsComponent
    }
}