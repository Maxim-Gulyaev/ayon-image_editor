package com.maxim.data.di

import com.maxim.data.repository.SettingsRepositoryImpl
import com.maxim.domain.repository.SettingsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository
}