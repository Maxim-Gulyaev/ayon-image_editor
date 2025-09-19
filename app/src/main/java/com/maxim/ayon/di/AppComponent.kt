package com.maxim.ayon.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModelProvider
import com.maxim.data.di.DataModule
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.di.DataStoreModule
import com.maxim.datastore.di.UserPreferencesDataSourceModule
import com.maxim.domain.di.SettingsUseCaseModule
import com.maxim.domain.repository.SettingsRepository
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCase
import com.maxim.run.di.utils.RunDependencies
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
        SettingsUseCaseModule::class,
        MainViewModelModule::class,
    ]
)
interface AppComponent :
    SettingsDependencies,
    RunDependencies {

    fun viewModelFactory(): ViewModelProvider.Factory

    override fun userPreferencesDataStore(): DataStore<UserPreferences>

    override fun userPreferencesDataSource(): UserPreferencesDataSource

    override fun settingsRepository(): SettingsRepository

    override fun getAppLanguageUseCase(): GetAppLanguageUseCase

    override fun setAppLanguageUseCase(): SetAppLanguageUseCase

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}