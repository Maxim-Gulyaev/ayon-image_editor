package com.maxim.ayon

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.common.result.Result
import com.maxim.common.result.asResult
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.settings.model.AppLanguageUi
import com.maxim.settings.model.toUi
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAppLanguageUseCase: GetAppLanguageUseCase,
): ViewModel() {

    fun accept(intent: InternalIntent) {
        when (intent) {
            InternalIntent.SetAppLanguageObserver -> {
                viewModelScope.launch {
                    setAppLanguageObserver()
                }
            }
        }
    }

    private fun setAppLanguage(language: AppLanguageUi) {
        val newLocale = LocaleListCompat.forLanguageTags(language.tag)
        val currentLocale = AppCompatDelegate.getApplicationLocales()

        if (currentLocale.toLanguageTags() != newLocale.toLanguageTags()) {
            AppCompatDelegate.setApplicationLocales(newLocale)
        }
    }

    private suspend fun setAppLanguageObserver() {
        getAppLanguageUseCase()
            .asResult()
            .collect { result ->
                when (result) {
                    is Result.Success -> {
                        val language = result.data.toUi()
                        setAppLanguage(language)
                    }

                    is Result.Error -> {
                        Log.e("ayon_error", "mainViewModel ${result.exception}")
                    }

                    else -> {}
                }
        }
    }
}

sealed interface InternalIntent {

    data object SetAppLanguageObserver : InternalIntent
}