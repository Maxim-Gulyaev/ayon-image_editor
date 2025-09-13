package com.maxim.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.userPrefsDataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStore(context: Context): DataStore<UserPreferences> =
        context.userPrefsDataStore
}