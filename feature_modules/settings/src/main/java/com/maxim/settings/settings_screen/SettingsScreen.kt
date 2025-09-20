package com.maxim.settings.settings_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.settings.R
import com.maxim.ui.component.BackgroundContainer
import com.maxim.ui.component.ContainerCard
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onLanguageClick: () -> Unit,
) {
    SettingsScreenContent(
        onLanguageClick = onLanguageClick,
    )
}

@Composable
private fun SettingsScreenContent(
    modifier: Modifier = Modifier,
    onLanguageClick: () -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        item {
            Language(
                onClick = onLanguageClick
            )
        }
    }
}

@Composable
private fun Language(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    ContainerCard() {
        Text(
            modifier = modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .clickable {
                    onClick()
                },
            text = stringResource(R.string.language),
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
            SettingsScreenContent(
                onLanguageClick = {}
            )
        }
    }
}

@AdaptivePreviewLight
@Preview
@Composable
private fun PreviewSettingsScreenLight() {
    AyonTheme {
        BackgroundContainer {
            SettingsScreenContent(
                onLanguageClick = {}
            )
        }
    }
}
