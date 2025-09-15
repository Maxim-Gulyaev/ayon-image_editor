package com.maxim.ayon.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.maxim.data.di.DataModule
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.di.DataStoreModule
import com.maxim.datastore.di.UserPreferencesDataSourceModule
import com.maxim.domain.repository.SettingsRepository
import com.maxim.settings.di.utils.SettingsDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        DataStoreModule::class,
        UserPreferencesDataSourceModule::class,
        DataModule::class,
    ]
)
interface AppComponent: SettingsDependencies {

    override fun userPreferencesDataStore(): DataStore<UserPreferences>

    override fun userPreferencesDataSource(): UserPreferencesDataSource

    override fun settingsRepository(): SettingsRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}