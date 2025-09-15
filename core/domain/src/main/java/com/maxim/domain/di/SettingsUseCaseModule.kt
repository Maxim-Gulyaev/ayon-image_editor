package com.maxim.domain.di

import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface SettingsUseCaseModule {

    @Binds
    fun bindGetAppLanguageUseCase(getAppLanguageUseCaseImpl: GetAppLanguageUseCaseImpl): GetAppLanguageUseCase
}