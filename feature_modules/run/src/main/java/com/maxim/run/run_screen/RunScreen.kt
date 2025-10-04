package com.maxim.run.run_screen

import android.R.attr.onClick
import android.R.attr.top
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxim.run.R
import com.maxim.ui.component.BackgroundContainer
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.theme.AyonTypography
import com.maxim.ui.theme.LocalCustomColorScheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight
import java.util.Locale
import kotlin.time.Duration

private const val FORMAT_HOUR_MIN_SEC = "%02d:%02d:%02d"
private const val FORMAT_MIN_SEC = "%02d:%02d"

@Composable
fun RunScreen(
    viewModel: RunViewModel,
    quitRunScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    RunScreenContainer(
        uiState = uiState,
        onStartClick = {
            viewModel.accept(RunScreenIntent.OnStartClick)
        },
        onResetClick = {
            viewModel.accept(RunScreenIntent.OnResetClick)
        },
        onSaveClick = {
            viewModel.accept(RunScreenIntent.OnSaveClick)
            quitRunScreen()
        },
    )
}

@Composable
private fun RunScreenContainer(
    uiState: RunUiState,
    onStartClick: () -> Unit,
    onResetClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.weight(0.7f))

        SaveButtonBlock(
            onClick = onSaveClick,
            colors = uiState.getSaveButtonColors(),
        )

        Spacer(modifier = modifier.weight(0.7f))

        StopwatchBlock(uiState.jogDuration)

        Spacer(modifier = modifier.weight(1f))

        StartButtonBlock(
            isStopwatchRunning = uiState.isStopwatchRunning,
            isElapsedTimeInitial = uiState.jogDuration == RunUiState.initial.jogDuration,
            onStartClick = onStartClick,
            onResetClick = onResetClick,
        )

        Spacer(modifier = modifier.weight(0.2f))
    }
}

@Composable
private fun StopwatchBlock(
    jogDuration: Duration,
    modifier: Modifier = Modifier,
) {
    val durationString = if (jogDuration.inWholeHours > 0) {
        String.format(
            Locale.US,
            FORMAT_HOUR_MIN_SEC,
            jogDuration.inWholeHours,
            jogDuration.inWholeMinutes,
            jogDuration.inWholeSeconds
        )
    } else {
        String.format(
            Locale.US,
            FORMAT_MIN_SEC,
            jogDuration.inWholeMinutes,
            jogDuration.inWholeSeconds
        )
    }

    Card(
        modifier = modifier
            .size(260.dp)
            .aspectRatio(1f),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceBright),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = durationString,
                style = MaterialTheme.typography.displayMedium,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun SaveButtonBlock(
    onClick: () -> Unit,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.weight(0.3f))
        Button(
            modifier = Modifier
                .weight(0.7f, fill = false),
            onClick = onClick,
            shape = CircleShape,
            colors = colors,
        ) {
            Text(
                text = stringResource(R.string.save),
                style = AyonTypography.headlineMedium
            )
        }
    }
}

@Composable
private fun StartButtonBlock(
    isStopwatchRunning: Boolean,
    isElapsedTimeInitial: Boolean,
    onStartClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = LocalCustomColorScheme.current

    val startButtonColor = remember(isStopwatchRunning, colors) {
        if (isStopwatchRunning) colors.cautionOrange else colors.positiveGreen
    }

    val startButtonTextRes = remember(isStopwatchRunning, isElapsedTimeInitial) {
        when {
            !isElapsedTimeInitial && !isStopwatchRunning -> R.string.continue_stopwatch
            isStopwatchRunning -> R.string.stop
            else -> R.string.start
        }
    }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart,
        ) {
            Button(
                modifier = Modifier.height(60.dp),
                onClick = onResetClick,
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error,
                )
            ) {
                Text(
                    text = stringResource(R.string.reset),
                    style = AyonTypography.headlineMedium
                )
            }
        }

        Button(
            modifier = Modifier.sizeIn(minWidth = 160.dp, minHeight = 160.dp),
            onClick = onStartClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = startButtonColor,
            )
        ) {
            Text(
                text = stringResource(startButtonTextRes),
                style = AyonTypography.headlineLarge,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun RunUiState.getSaveButtonColors(): ButtonColors {
    val shouldShowSaveButton = jogDuration > Duration.ZERO && !isStopwatchRunning
    return if (shouldShowSaveButton) {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSecondary,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        )
    } else {
        ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
        )
    }
}


@AdaptivePreviewDark
@Preview
@Composable
private fun PreviewRunScreenDark() {
    AyonTheme() {
        BackgroundContainer {
            RunScreenContainer(
                uiState = RunUiState.initial,
                onStartClick = {},
                onResetClick = {},
                onSaveClick = {},
            )
        }
    }
}

@AdaptivePreviewLight
@Preview
@Composable
private fun PreviewRunScreenLight() {
    AyonTheme {
        BackgroundContainer {
            RunScreenContainer(
                uiState = RunUiState.initial,
                onStartClick = {},
                onResetClick = {},
                onSaveClick = {},
            )
        }
    }
}