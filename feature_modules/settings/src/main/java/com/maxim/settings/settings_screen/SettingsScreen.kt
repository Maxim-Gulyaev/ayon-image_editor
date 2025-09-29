package com.maxim.settings.settings_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
    onLanguageClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SettingsScreenContent(
        onLanguageClick = onLanguageClick,
        onBackClick = onBackClick,
    )
}

@Composable
private fun SettingsScreenContent(
    onLanguageClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            SettingsTopAppBar(
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
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
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingsTopAppBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.top_app_bar_settings))
        },
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_app_bar_back),
                    contentDescription = null,
                )
            }
        }
    )
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
                onLanguageClick = {},
                onBackClick = {}
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
                onLanguageClick = {},
                onBackClick = {}
            )
        }
    }
}
