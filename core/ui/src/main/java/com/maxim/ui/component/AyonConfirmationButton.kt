package com.maxim.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maxim.ui.R

@Composable
fun AyonConfirmationButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    @StringRes text: Int = R.string.save,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            disabledContentColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        content = { Text(text = stringResource(text)) }
    )
}