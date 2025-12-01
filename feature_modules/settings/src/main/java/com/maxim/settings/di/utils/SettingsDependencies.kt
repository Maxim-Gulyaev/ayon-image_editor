package com.maxim.settings.di.utils

import androidx.datastore.core.DataStore
import com.maxim.common.util.Logger
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.data.UserPreferences
import com.maxim.domain.repository.SettingsRepository
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCase

interface SettingsDependencies {
    fun userPreferencesDataStore(): DataStore<UserPreferences>
    fun userPreferencesDataSource(): UserPreferencesDataSource
    fun settingsRepository(): SettingsRepository
    fun getAppLanguageUseCase(): GetAppLanguageUseCase
    fun setAppLanguageUseCase(): SetAppLanguageUseCase
    fun logger(): Logger
}