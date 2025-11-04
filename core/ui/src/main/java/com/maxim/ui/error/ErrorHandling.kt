package com.maxim.ui.error

import android.database.sqlite.SQLiteException
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.maxim.ui.R
import com.maxim.ui.component.AyonBaseDialog

@Composable
fun AyonErrorScreen(
    throwable: Throwable,
    onPositiveClick: () -> Unit,
) {
    val ( @StringRes titleRes, @StringRes descriptionRes) = getDialogContent(throwable)

    AyonBaseDialog(
        title = stringResource(titleRes),
        description = stringResource(descriptionRes),
        positiveButtonText = stringResource(R.string.error_dialog_positive),
        onPositiveClick = onPositiveClick,
    )
}

@Composable
private fun getDialogContent(throwable: Throwable): Pair<Int, Int> {
    return when {
        throwable is SQLiteException -> R.string.error to R.string.database_error
        else -> R.string.error to R.string.unknown_error
    }
}