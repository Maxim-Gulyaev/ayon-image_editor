package com.maxim.settings.di.utils

import androidx.datastore.core.DataStore
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.data.UserPreferences

interface SettingsDependencies {
    fun userPreferencesDataStore(): DataStore<UserPreferences>
    fun userPreferencesDataSource(): UserPreferencesDataSource
}