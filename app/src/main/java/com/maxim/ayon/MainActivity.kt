package com.maxim.ayon

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.maxim.ayon.bottom_bar_navigation.BottomBarNavigation
import com.maxim.ui.theme.AyonTheme

class MainActivity : AppCompatActivity() {

    private val appComponent by lazy { (application as AyonApplication).appComponent }
    private val mainViewModel: MainViewModel by viewModels { appComponent.viewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        mainViewModel.accept(InternalIntent.SetAppLanguageObserver)

        enableEdgeToEdge()
        setContent {
            AyonTheme {
                BottomBarNavigation(appComponent)
            }
        }
    }
}
