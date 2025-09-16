package com.maxim.domain.di

import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCaseImpl
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCase
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface SettingsUseCaseModule {

    @Binds
    fun bindGetAppLanguageUseCase(getAppLanguageUseCaseImpl: GetAppLanguageUseCaseImpl): GetAppLanguageUseCase

    @Binds
    fun bindSetAppLanguageUseCase(setAppLanguageUseCaseImpl: SetAppLanguageUseCaseImpl): SetAppLanguageUseCase
}