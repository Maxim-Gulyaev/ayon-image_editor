package com.maxim.ayon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maxim.ayon.navigation.MainNavigation
import com.maxim.ui.theme.AyonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AyonTheme {
                MainNavigation()
            }
        }
    }
}
