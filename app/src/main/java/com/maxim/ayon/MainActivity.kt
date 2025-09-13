package com.maxim.ayon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.maxim.ayon.bottom_bar_navigation.BottomBarNavigation
import com.maxim.settings.language.LanguageViewModel
import com.maxim.settings.language.LanguageViewModelFactory
import com.maxim.ui.theme.AyonTheme

class MainActivity : ComponentActivity() {

    private val languageViewModel: LanguageViewModel by viewModels {
        val appComponent = (application as AyonApplication).appComponent
        LanguageViewModelFactory(appComponent.userPreferencesDataStore())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AyonTheme {
                BottomBarNavigation(languageViewModel = languageViewModel)
            }
        }
    }
}
