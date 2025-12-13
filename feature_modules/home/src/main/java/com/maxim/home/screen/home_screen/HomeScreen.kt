package com.maxim.home.screen.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maxim.home.R
import com.maxim.home.util.homeScreenUiStateMock
import com.maxim.model.Jog
import com.maxim.ui.component.AyonVerticalSpacer
import com.maxim.ui.component.LoadingScreen
import com.maxim.ui.error.AyonErrorScreen
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.theme.AyonTypography
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.time.Duration

private val DAY_MONTH_YEAR_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy")

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
    state: HomeScreenUiState,
    modifier: Modifier = Modifier,
) {
    when (state) {

        is HomeScreenUiState.Success -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                JogHistoryBlock(state.jogList)
            }
        }

        is HomeScreenUiState.Error -> {
            AyonErrorScreen(state.throwable) { } // todo assign action
        }

        HomeScreenUiState.Loading -> {
            LoadingScreen()
        }
    }
}

@Composable
private fun JogHistoryBlock(
    jogs: List<Jog>,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = stringResource(R.string.jog_history),
                        style = AyonTypography.titleMedium
                    )
                }
            }

            items(
                items = jogs,
            ) { item ->
                AyonVerticalSpacer(8.dp)
                JogHistoryItem(
                    date = item.date.toFormattedDate(),
                    duration = item.duration.toFormattedDuration(),
                )
            }
        }
    }
}

@Composable
private fun JogHistoryItem(
    date: String,
    duration: String,
    modifier: Modifier = Modifier,
) {
    Row {
        Text(date)

        Spacer(modifier = modifier.weight(1f))

        Text(duration)
    }
}

@Composable
private fun Duration.toFormattedDuration(
    showSeconds: Boolean = true
): String {
    val elapsedSeconds = inWholeSeconds

    val hours = elapsedSeconds / 3600
    val minutes = (elapsedSeconds % 3600) / 60
    val seconds = elapsedSeconds % 60

    val h = stringResource(R.string.duration_h_short)
    val m = stringResource(R.string.duration_min_short)
    val s = stringResource(R.string.duration_sec_short)

    return buildString {
        if (hours > 0) {
            append(hours)
            append(' ')
            append(h)
        }

        if (minutes > 0) {
            if (isNotEmpty()) append(' ')
            append(minutes)
            append(' ')
            append(m)
        }

        if (showSeconds && (seconds > 0 || isEmpty())) {
            if (isNotEmpty()) append(' ')
            append(seconds)
            append(' ')
            append(s)
        }
    }
}


private fun LocalDate.toFormattedDate(): String =
    format(DAY_MONTH_YEAR_FORMATTER)

@Composable
@AdaptivePreviewLight
@AdaptivePreviewDark
private fun HomeScreenContentPreview() {
    val state = remember {
        mutableStateOf(
            homeScreenUiStateMock()
        )
    }
    AyonTheme {
        HomeScreenContent(
            state = state.value,
        )
    }
}