package com.maxim.home.screen.home_screen

import com.maxim.home.model.JogUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeScreenUiState(
    val jogList: ImmutableList<JogUi>,
) {
    companion object {
        fun initial() = HomeScreenUiState(
            jogList = persistentListOf()
        )

        // todo remove this
        fun mock() = HomeScreenUiState(
            jogList = persistentListOf(
                JogUi.mock(),
                JogUi.mock(),
                JogUi.mock(),
                JogUi.mock(),
                JogUi.mock(),
                JogUi.mock(),
            )
        )
    }
}

