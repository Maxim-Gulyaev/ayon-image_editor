package com.maxim.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maxim.ui.util.NoRippleInteractionSource

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    shouldShowRipple: Boolean = false,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        interactionSource = if (shouldShowRipple) null else NoRippleInteractionSource,
        onClick = { onClick() }
    ) { content() }
}