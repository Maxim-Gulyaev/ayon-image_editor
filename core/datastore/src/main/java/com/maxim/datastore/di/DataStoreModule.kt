package com.maxim.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.userPreferencesDataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataStoreModule {

    @Singleton
    @Provides
    fun provideUserPrefsDataStore(context: Context): DataStore<UserPreferences> =
        context.userPreferencesDataStore

    @Singleton
    @Provides
    fun provideUserPrefsDataSource(dataStore: DataStore<UserPreferences>) =
        UserPreferencesDataSource(dataStore)
}