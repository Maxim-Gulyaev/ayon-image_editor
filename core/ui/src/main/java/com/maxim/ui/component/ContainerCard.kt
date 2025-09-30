package com.maxim.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maxim.ui.util.NoRippleInteractionSource

@Composable
fun ContainerCard(
    modifier: Modifier = Modifier,
    shouldEnableRipple: Boolean = false,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceBright),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        interactionSource = if (shouldEnableRipple) null else NoRippleInteractionSource,
    ) { content() }
}