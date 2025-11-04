package com.maxim.ui.error

import android.database.sqlite.SQLiteException
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.maxim.ui.R
import com.maxim.ui.component.AyonBaseDialog

@Composable
fun AyonErrorScreen(
    throwable: Throwable,
    callback: () -> Unit,
) {
    val (title, description) = getDialogContent(throwable)

    AyonBaseDialog(
        title = title,
        description = description,
        positiveButtonText = stringResource(R.string.error_dialog_positive),
        onPositiveClick = callback,
    )
}

@Composable
private fun getDialogContent(throwable: Throwable): Pair<String, String> {
    return when {
        throwable is SQLiteException -> stringResource(R.string.error) to stringResource(R.string.database_error)
        else -> stringResource(R.string.error) to stringResource(R.string.unknown_error)
    }
}