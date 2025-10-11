package com.maxim.domain.di

import com.maxim.domain.use_case.get_all_jogs.GetAllJogsUseCase
import com.maxim.domain.use_case.get_all_jogs.GetAllJogsUseCaseImpl
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCaseImpl
import com.maxim.domain.use_case.save_jog.SaveJogUseCase
import com.maxim.domain.use_case.save_jog.SaveJogUseCaseImpl
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCase
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindGetAppLanguageUseCase(impl: GetAppLanguageUseCaseImpl): GetAppLanguageUseCase

    @Binds
    fun bindSetAppLanguageUseCase(impl: SetAppLanguageUseCaseImpl): SetAppLanguageUseCase

    @Binds
    fun bindSaveJogUseCase(impl: SaveJogUseCaseImpl): SaveJogUseCase

    @Binds
    fun bindGetAllJogsUseCase(impl: GetAllJogsUseCaseImpl): GetAllJogsUseCase
}