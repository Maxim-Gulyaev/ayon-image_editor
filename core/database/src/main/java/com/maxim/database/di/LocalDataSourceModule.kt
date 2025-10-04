package com.maxim.database.di

import com.maxim.database.JogsLocalDataSource
import com.maxim.database.JogsLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface LocalDataSourceModule {

    @Singleton
    @Binds
    fun bindsJogsLocalDataSource(impl: JogsLocalDataSourceImpl): JogsLocalDataSource
}