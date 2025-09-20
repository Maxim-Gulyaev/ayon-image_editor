package com.maxim.run.run_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.run.R
import com.maxim.ui.components.BackgroundContainer
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.theme.AyonTypography
import com.maxim.ui.theme.LocalCustomColorScheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight
import java.util.Locale


@Composable
fun RunScreen(
    modifier: Modifier = Modifier,
    viewModel: RunViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    RunScreenContainer(
        uiState = uiState,
        onStartClick = { viewModel.accept(RunScreenIntent.OnStartClick) },
        onResetClick = { viewModel.accept(RunScreenIntent.OnResetClick) }
    )
}

@Composable
private fun RunScreenContainer(
    uiState: RunUiState,
    onStartClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.weight(1f))

        StopwatchBlock(uiState.stopwatchValue)

        Spacer(modifier = modifier.weight(1f))

        StartButtonBlock(
            isStopwatchRunning = uiState.isStopwatchRunning,
            isElapsedTimeInitial = uiState.stopwatchValue == RunUiState.initial.stopwatchValue,
            onStartClick = onStartClick,
            onResetClick = onResetClick,
        )

        Spacer(modifier = modifier.weight(0.2f))
    }
}

@Composable
private fun StopwatchBlock(
    elapsedTimeMillis: Long,
    modifier: Modifier = Modifier,
) {
    val totalSeconds = elapsedTimeMillis / 1000
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60

    val timeString = if (hours > 0) {
        String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds)
    } else {
        String.format(Locale.US, "%02d:%02d", minutes, seconds)
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
                text = timeString,
                style = MaterialTheme.typography.displayMedium,
                modifier = modifier
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
            )
        }
    }
}