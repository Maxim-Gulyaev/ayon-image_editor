package com.maxim.run.di.component

import androidx.lifecycle.ViewModelProvider
import com.maxim.run.di.module.RunViewModelModule
import com.maxim.run.di.utils.RunDependencies
import com.maxim.run.di.utils.RunScope
import dagger.Component

@RunScope
@Component(
    dependencies = [RunDependencies::class],
    modules = [RunViewModelModule::class],
)
interface RunComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: RunDependencies): RunComponent
    }
}