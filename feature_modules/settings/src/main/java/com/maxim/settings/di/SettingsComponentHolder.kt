package com.maxim.settings.di

import androidx.lifecycle.ViewModel

class SettingsComponentHolder(appComponent: SettingsDependencies) : ViewModel() {
    val settingsComponent: SettingsComponent =
        DaggerSettingsComponent.factory().create(appComponent)
}