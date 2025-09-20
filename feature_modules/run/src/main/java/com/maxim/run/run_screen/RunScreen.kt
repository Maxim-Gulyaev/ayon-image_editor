package com.maxim.run.run_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.run.R
import com.maxim.ui.components.AyonVerticalSpacer
import com.maxim.ui.components.BackgroundContainer
import com.maxim.ui.components.ContainerCard
import com.maxim.ui.components.ItemCard
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
    Column(modifier.fillMaxSize()) {
        AyonVerticalSpacer(120.dp)

        StopwatchBlock(uiState.stopwatchValue)

        Spacer(modifier = modifier.weight(1f))

        StartButtonBlock(
            modifier = modifier.weight(1f),
            isStopwatchRunning = uiState.isStopwatchRunning,
            onStartClick = onStartClick,
            onResetClick = onResetClick,
        )

        AyonVerticalSpacer(16.dp)
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

    ContainerCard(
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        ItemCard(
            modifier = modifier.padding(horizontal = 12.dp, vertical = 32.dp),
        ) {
            Box(
                modifier = modifier.fillMaxWidth(),
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
}

@Composable
private fun StartButtonBlock(
    isStopwatchRunning: Boolean,
    onStartClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val buttonColor =
        if (isStopwatchRunning) LocalCustomColorScheme.current.cautionOrange
        else LocalCustomColorScheme.current.positiveGreen

    val buttonText =
        if (isStopwatchRunning) stringResource(R.string.stop)
        else stringResource(R.string.start)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = modifier.size(160.dp),
            onClick = onStartClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
            )
        ) {
            Text(
                text = buttonText,
                style = AyonTypography.headlineLarge
            )
        }
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart,
        ) {
            Button(
                modifier = modifier.height(60.dp),
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