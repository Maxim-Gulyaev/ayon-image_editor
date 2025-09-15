package com.maxim.settings.di.component

import androidx.lifecycle.ViewModelProvider
import com.maxim.settings.di.utils.SettingsDependencies
import com.maxim.settings.di.utils.SettingsScope
import com.maxim.settings.di.module.SettingsViewModelModule
import dagger.Component

@SettingsScope
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