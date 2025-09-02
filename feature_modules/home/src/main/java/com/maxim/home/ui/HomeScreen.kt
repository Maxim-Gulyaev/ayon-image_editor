package com.maxim.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxim.home.model.HomeScreenUiState
import com.maxim.home.view_model.HomeScreenViewModel
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        HomeScreenContent(
            state = uiState
        )
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: HomeScreenUiState,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = modifier
                .size(300.dp)
                .aspectRatio(1f),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceBright),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        ) {

        }
    }
}

@Composable
@AdaptivePreviewLight
@AdaptivePreviewDark
private fun HomeScreenContentPreview() {
    val state = remember {
        mutableStateOf(
            HomeScreenUiState(
                time = "00:00"
            )
        )
    }
    AyonTheme {
        HomeScreenContent(
            state = state.value,
        )
    }
}