package com.maxim.settings.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.ui.components.BackgroundContainer
import com.maxim.ui.components.ItemCard
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
) {
    SettingsScreenContent()
}

@Composable
private fun SettingsScreenContent(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        item { Language() }
    }
}

@Composable
private fun Language(
    modifier: Modifier = Modifier,
) {
    ItemCard {
        Text(
            modifier = modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            text = "Language",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@AdaptivePreviewDark
@Preview
@Composable
private fun PreviewSettingsScreenDark() {
    AyonTheme() {
        BackgroundContainer {
            SettingsScreenContent()
        }

    }
}

@AdaptivePreviewLight
@Preview
@Composable
private fun PreviewSettingsScreenLight() {
    AyonTheme {
        BackgroundContainer {
            SettingsScreenContent()
        }

    }
}
