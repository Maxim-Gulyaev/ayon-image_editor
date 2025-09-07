package com.maxim.home.model

import androidx.compose.runtime.Immutable

@Immutable
data class HomeScreenUiState(
    val time: String?,
) {
    companion object {
        val initial = HomeScreenUiState(
            time = null,
        )
    }
}