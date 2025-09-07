package com.maxim.settings.language

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxim.ui.components.BackgroundContainer
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun LanguageScreen(
    modifier: Modifier = Modifier,
    viewModel: LanguageViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LanguageScreenContent(uiState = uiState)
}

@Composable
private fun LanguageScreenContent(
    modifier: Modifier = Modifier,
    uiState: LanguageUiState,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        items(
            items = uiState.languages,
            key = { it }
        ) { language ->
            Text(text = language.toString())
        }
    }
}

@AdaptivePreviewDark
@Preview
@Composable
private fun PreviewLanguageScreenDark() {
    AyonTheme() {
        BackgroundContainer {
            LanguageScreenContent(uiState = LanguageUiState.initial)
        }
    }
}

@AdaptivePreviewLight
@Preview
@Composable
private fun PreviewLanguageScreenLight() {
    AyonTheme {
        BackgroundContainer {
            LanguageScreenContent(uiState = LanguageUiState.initial)
        }
    }
}