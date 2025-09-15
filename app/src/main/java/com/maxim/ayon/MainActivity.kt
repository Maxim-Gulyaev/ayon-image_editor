package com.maxim.ayon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maxim.ayon.bottom_bar_navigation.BottomBarNavigation
import com.maxim.ui.theme.AyonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val appComponent = (application as AyonApplication).appComponent

        setContent {
            AyonTheme {
                BottomBarNavigation(appComponent)
            }
        }
    }
}
