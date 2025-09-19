package com.maxim.run.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class RunNavRoute() {

    @Serializable
    data object RunScreen : RunNavRoute()
}