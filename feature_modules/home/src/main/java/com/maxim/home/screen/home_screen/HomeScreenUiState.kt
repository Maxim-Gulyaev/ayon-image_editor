package com.maxim.home.screen.home_screen

import com.maxim.model.Jog
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeScreenUiState(
    val jogList: ImmutableList<Jog>,
) {
    companion object {
        fun initial() = HomeScreenUiState(
            jogList = persistentListOf()
        )
    }
}

