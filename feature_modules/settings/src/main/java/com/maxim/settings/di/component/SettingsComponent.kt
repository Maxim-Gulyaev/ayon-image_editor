package com.maxim.settings.di.component

import androidx.lifecycle.ViewModelProvider
import com.maxim.domain.di.SettingsUseCaseModule
import com.maxim.settings.di.module.SettingsViewModelModule
import com.maxim.settings.di.utils.SettingsDependencies
import com.maxim.settings.di.utils.SettingsScope
import dagger.Component

@SettingsScope
@Component(
    dependencies = [SettingsDependencies::class],
    modules = [
        SettingsViewModelModule::class,
        SettingsUseCaseModule::class,
    ]
)
interface SettingsComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: SettingsDependencies): SettingsComponent
    }
}