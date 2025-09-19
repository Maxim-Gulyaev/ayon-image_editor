package com.maxim.run.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxim.common.di.AyonViewModelFactory
import com.maxim.common.di.ViewModelKey
import com.maxim.run.di.utils.RunScope
import com.maxim.run.run_screen.RunViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RunViewModelModule {

    @RunScope
    @Binds
    abstract fun bindViewModelFactory(factory: AyonViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RunViewModel::class)
    abstract fun bindLanguageViewModel(viewModel: RunViewModel): ViewModel
}