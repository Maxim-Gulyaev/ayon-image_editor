package com.maxim.home.di.utils

import androidx.lifecycle.ViewModel
import com.maxim.home.di.component.DaggerHomeComponent
import com.maxim.home.di.component.HomeComponent

class HomeComponentHolder(appComponent: HomeDependencies) : ViewModel() {
    val homeComponent: HomeComponent =
        DaggerHomeComponent.factory().create(appComponent)
}