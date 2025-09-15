package com.maxim.settings.di.utils

import androidx.lifecycle.ViewModel
import com.maxim.settings.di.component.DaggerSettingsComponent
import com.maxim.settings.di.component.SettingsComponent

class SettingsComponentHolder(appComponent: SettingsDependencies) : ViewModel() {
    val settingsComponent: SettingsComponent =
        DaggerSettingsComponent.factory().create(appComponent)
}