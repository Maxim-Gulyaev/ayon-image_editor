package com.maxim.common.di.module

import com.maxim.common.util.AyonLog
import com.maxim.common.util.Logger
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
class LogModule {

    @Provides
    fun provideLogger() : Logger = AyonLog()
}