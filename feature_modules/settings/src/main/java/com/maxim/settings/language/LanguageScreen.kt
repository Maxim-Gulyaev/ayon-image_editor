package com.maxim.settings.language

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.settings.language.LanguageIntent.OnLanguageClick
import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.utils.displayNameRes
import com.maxim.ui.components.AyonVerticalSpacer
import com.maxim.ui.components.BackgroundContainer
import com.maxim.ui.components.ContainerCard
import com.maxim.ui.components.ItemCard
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.theme.AyonTypography
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight

@Composable
fun LanguageScreen(
    modifier: Modifier = Modifier,
    viewModel: LanguageViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.currentAppLanguage) {
        Log.d("maxlog", "currentLanguage = ${uiState.currentAppLanguage}")
    }

    LanguageScreenContent(
        uiState = uiState,
        onClick = { viewModel.accept(OnLanguageClick(it)) }
    )
}

@Composable
private fun LanguageScreenContent(
    modifier: Modifier = Modifier,
    uiState: LanguageUiState,
    onClick: (AppLanguageUi) -> Unit,
) {
    ContainerCard(
        modifier = modifier.padding(16.dp),
    ) {
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
                        isSelected = currentAppLanguage == item,
                        onClick = { onClick(item) }
                    )
                    if (index < appLanguages.lastIndex) {
                        AyonVerticalSpacer(8.dp)
                    }
                }
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
                onClick = {}
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
                onClick = {}
            )
        }
    }
}