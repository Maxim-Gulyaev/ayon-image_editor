package com.maxim.home.screen.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maxim.home.R
import com.maxim.home.model.JogUi
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    modifier: Modifier = Modifier,
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
        JogHistoryBlock(state.jogList)
    }
}

@Composable
private fun JogHistoryBlock(
    jogs: List<JogUi>,
) {
    LazyColumn {
        item {
            Text(stringResource(R.string.jog_history))
        }
        items(
            items = jogs,
        ) { item ->
            JogHistoryItem(item.date.toString(), item.duration.toString())
        }
    }
}

@Composable
private fun JogHistoryItem(
    date: String,
    duration: String,
) {
    Row {
        Text(date)
        Text(duration)
    }
}

@Composable
@AdaptivePreviewLight
@AdaptivePreviewDark
private fun HomeScreenContentPreview() {
    val state = remember {
        mutableStateOf(
            HomeScreenUiState.mock()
        )
    }
    AyonTheme {
        HomeScreenContent(
            state = state.value,
        )
    }
}