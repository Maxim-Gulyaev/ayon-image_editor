package com.maxim.common.di.module

import com.maxim.common.util.AyonLog
import com.maxim.common.util.Logger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LogModule {

    @Singleton
    @Provides
    fun provideLogger() : Logger = AyonLog()
}