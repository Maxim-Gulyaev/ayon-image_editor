package com.maxim.run.di.utils

import androidx.lifecycle.ViewModel
import com.maxim.run.di.component.DaggerRunComponent
import com.maxim.run.di.component.RunComponent

class RunComponentHolder(appComponent: RunDependencies) : ViewModel() {
    val runComponent: RunComponent =
        DaggerRunComponent.factory().create(appComponent)
}
