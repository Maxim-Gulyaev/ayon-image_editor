package com.maxim.ayon.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.di.DataStoreModule
import com.maxim.settings.di.utils.SettingsDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [DataStoreModule::class]
)
interface AppComponent: SettingsDependencies {

    override fun userPreferencesDataStore(): DataStore<UserPreferences>

    override fun userPreferencesDataSource(): UserPreferencesDataSource

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}