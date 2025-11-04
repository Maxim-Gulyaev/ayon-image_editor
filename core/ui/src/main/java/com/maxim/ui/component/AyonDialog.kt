package com.maxim.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maxim.common.constants.empty
import com.maxim.ui.theme.AyonTypography

@Composable
fun AyonBaseDialog(
    title: String = String.empty,
    description: String = String.empty,
    positiveButtonText: String = String.empty,
    negativeButtonText: String = String.empty,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    extraContent: @Composable () -> Unit = {}
) {

    AlertDialog(
        containerColor = MaterialTheme.colorScheme.tertiary,
        title = {
            if (title.isNotEmpty()) Text(
                text = title,
                style = AyonTypography.headlineMedium,
                color = MaterialTheme.colorScheme.onTertiary,
            )
        },

        text = {
            Column {
                if (description.isNotEmpty()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = description,
                        style = AyonTypography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                extraContent()
            }
        },

        dismissButton = {
            TextButton(onClick = onNegativeClick) {
                Text(
                    text = negativeButtonText,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        },

        confirmButton = {
            TextButton(onClick = onPositiveClick) {
                Text(
                    text = positiveButtonText,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        },

        onDismissRequest = onDismissRequest,
    )
}