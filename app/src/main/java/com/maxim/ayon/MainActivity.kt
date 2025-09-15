package com.maxim.ayon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maxim.ayon.bottom_bar_navigation.BottomBarNavigation
import com.maxim.settings.di.DaggerSettingsComponent
import com.maxim.ui.theme.AyonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val appComponent = (application as AyonApplication).appComponent
        val settingsComponent = DaggerSettingsComponent.factory().create(appComponent)

        setContent {
            AyonTheme {
                BottomBarNavigation(settingsComponent)
            }
        }
    }
}
