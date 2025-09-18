package com.maxim.ayon

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.data.mapper.toData
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.model.AppLanguage
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

    private fun setAppLanguage(language: AppLanguage) {
        val newLocale = LocaleListCompat.forLanguageTags(language.tag)
        val currentLocale = AppCompatDelegate.getApplicationLocales()

        if (currentLocale.toLanguageTags() != newLocale.toLanguageTags()) {
            AppCompatDelegate.setApplicationLocales(newLocale)
        }
    }

    private suspend fun setAppLanguageObserver() {
        getAppLanguageUseCase().collect { language ->
            setAppLanguage(language.toData())
        }
    }
}

sealed interface InternalIntent {

    data object SetAppLanguageObserver : InternalIntent
}