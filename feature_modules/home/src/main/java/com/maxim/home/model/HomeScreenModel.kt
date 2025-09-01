package com.maxim.home.model

data class HomeScreenUiState(
    val time: String?,
) {
    companion object {
        val initial = HomeScreenUiState(
            time = null,
        )
    }
}