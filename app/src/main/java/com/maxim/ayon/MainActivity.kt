package com.maxim.ayon

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.lifecycleScope
import com.maxim.ayon.bottom_bar_navigation.BottomBarNavigation
import com.maxim.ui.theme.AyonTheme
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val appComponent = (application as AyonApplication).appComponent
        val userPreferencesDataSource = appComponent.userPreferencesDataSource()

        lifecycleScope.launch {
            userPreferencesDataSource.appLanguage.collect { language ->
                val newLocale = LocaleListCompat.forLanguageTags(language.tag)
                val currentLocale = AppCompatDelegate.getApplicationLocales()

                if (currentLocale.toLanguageTags() != newLocale.toLanguageTags()) {
                    AppCompatDelegate.setApplicationLocales(newLocale)
                }
            }
        }

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AyonTheme {
                BottomBarNavigation(appComponent)
            }
        }
    }
}
