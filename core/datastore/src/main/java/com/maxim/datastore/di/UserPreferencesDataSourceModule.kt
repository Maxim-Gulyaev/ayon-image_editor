package com.maxim.datastore.di

import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.UserPreferencesDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UserPreferencesDataSourceModule {

    @Singleton
    @Binds
    fun bindUserPreferencesDataSource(impl: UserPreferencesDataSourceImpl): UserPreferencesDataSource
}