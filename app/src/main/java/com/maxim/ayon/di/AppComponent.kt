package com.maxim.ayon.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.di.DataStoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [DataStoreModule::class]
)
interface AppComponent {

    fun userPreferencesDataStore(): DataStore<UserPreferences>

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}