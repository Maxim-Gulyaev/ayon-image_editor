package com.maxim.run.run_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxim.ui.components.AyonVerticalSpacer
import com.maxim.ui.components.BackgroundContainer
import com.maxim.ui.components.ContainerCard
import com.maxim.ui.components.ItemCard
import com.maxim.ui.theme.AyonTheme
import com.maxim.ui.theme.AyonTypography
import com.maxim.ui.theme.LocalCustomColorScheme
import com.maxim.ui.util.AdaptivePreviewDark
import com.maxim.ui.util.AdaptivePreviewLight


@Composable
fun RunScreen(
    modifier: Modifier = Modifier,
    viewModel: RunViewModel,
) {
    RunScreenContainer()
}

@Composable
private fun RunScreenContainer(
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize()) {
        AyonVerticalSpacer(120.dp)

        StopwatchBlock(1000)

        Spacer(modifier = modifier.weight(1f))

        StartButtonBlock(
            modifier = modifier.weight(1f),
            enabled = true,
            onClick = {},
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
        String.format("%02d:%02d:%02d", hours, minutes, seconds)
    } else {
        String.format("%02d:%02d", minutes, seconds)
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
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = modifier.size(160.dp),
            onClick = onClick,
            shape = CircleShape,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = LocalCustomColorScheme.current.positiveGreen,
                disabledContainerColor = LocalCustomColorScheme.current.cautionOrange,
            )
        ) {
            Text(
                text = "Start",
                style = AyonTypography.headlineLarge
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
            RunScreenContainer()
        }
    }
}

@AdaptivePreviewLight
@Preview
@Composable
private fun PreviewRunScreenLight() {
    AyonTheme {
        BackgroundContainer {
            RunScreenContainer()
        }
    }
}