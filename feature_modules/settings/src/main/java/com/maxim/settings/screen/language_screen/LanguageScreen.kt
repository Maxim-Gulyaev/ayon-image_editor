package com.maxim.settings.screen.language_screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.settings.R
import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.screen.component.SettingsTopAppBar
import com.maxim.settings.screen.language_screen.LanguageScreenIntent.OnLanguageClick
import com.maxim.settings.screen.language_screen.LanguageScreenIntent.OnSaveButtonClick
import com.maxim.settings.utils.displayNameRes
import com.maxim.ui.component.AyonConfirmationButton
import com.maxim.ui.component.AyonVerticalSpacer
import com.maxim.ui.component.BackgroundContainer
import com.maxim.ui.component.ContainerCard
import com.maxim.ui.component.ItemCard
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.theme.AyonTypography
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun LanguageScreen(
    viewModel: LanguageViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    LanguageScreenContent(
        uiState = uiState,
        onLanguageItemClick = { viewModel.accept(OnLanguageClick(it)) },
        onSaveButtonClick = { viewModel.accept(OnSaveButtonClick) },
        onBackClick = onBackClick,
    )
}

@Composable
private fun LanguageScreenContent(
    modifier: Modifier = Modifier,
    uiState: LanguageUiState,
    onLanguageItemClick: (AppLanguageUi) -> Unit,
    onSaveButtonClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            SettingsTopAppBar(
                titleRes = R.string.language,
                onBackClick = onBackClick,
            )
        },
    ) { paddingValues ->
        ContainerCard(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp),
        ) {
            Column(modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                ) {
                    with (uiState) {
                        itemsIndexed(
                            items = appLanguages,
                            key = { _, item -> item.ordinal }
                        ) { index, item ->
                            LanguageItem(
                                displayNameRes = item.displayNameRes(),
                                isSelected = selectedLanguage == item,
                                onClick = { onLanguageItemClick(item) }
                            )
                            if (index < appLanguages.lastIndex) {
                                AyonVerticalSpacer(8.dp)
                            }
                        }
                    }
                }

                Spacer(modifier = modifier.weight(1f))

                AyonConfirmationButton(
                    modifier = modifier.padding(horizontal = 16.dp),
                    enabled = uiState.selectedLanguage != uiState.currentAppLanguage,
                    onClick = onSaveButtonClick,
                )
            }
        }
    }
}

@Composable
private fun LanguageItem(
    modifier: Modifier = Modifier,
    @StringRes displayNameRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    ItemCard(
        onClick = onClick,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = stringResource(displayNameRes),
                style = AyonTypography.bodyLarge,
            )
            RadioButton(
                selected = isSelected,
                onClick = {},
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.onSurface,
                    unselectedColor = MaterialTheme.colorScheme.onSurface,
                    disabledSelectedColor = MaterialTheme.colorScheme.onSurface,
                    disabledUnselectedColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

@AdaptivePreviewDark
@Preview
@Composable
private fun PreviewLanguageScreenDark() {
    AyonTheme() {
        BackgroundContainer {
            LanguageScreenContent(
                uiState = LanguageUiState.initial,
                onLanguageItemClick = {},
                onSaveButtonClick = {},
                onBackClick = {},
            )
        }
    }
}

@AdaptivePreviewLight
@Preview
@Composable
private fun PreviewLanguageScreenLight() {
    AyonTheme {
        BackgroundContainer {
            LanguageScreenContent(
                uiState = LanguageUiState.initial,
                onLanguageItemClick = {},
                onSaveButtonClick = {},
                onBackClick = {},
            )
        }
    }
}