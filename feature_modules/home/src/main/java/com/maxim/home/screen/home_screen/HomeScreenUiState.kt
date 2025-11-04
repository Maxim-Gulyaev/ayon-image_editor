package com.maxim.home.screen.home_screen

import com.maxim.model.Jog
import kotlinx.collections.immutable.ImmutableList

sealed interface HomeScreenUiState{
    data class Success(val jogList: ImmutableList<Jog>): HomeScreenUiState
    data class Error(val throwable: Throwable): HomeScreenUiState
    data object Loading: HomeScreenUiState
}