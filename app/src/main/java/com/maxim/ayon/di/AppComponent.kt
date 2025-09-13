package com.maxim.ayon.di

import android.content.Context
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.di.DataStoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [DataStoreModule::class]
)
interface AppComponent {

    fun userPreferencesDataSource(): UserPreferencesDataSource

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}