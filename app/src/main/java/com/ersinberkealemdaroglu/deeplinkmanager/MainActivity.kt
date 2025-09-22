package com.ersinberkealemdaroglu.deeplinkmanager

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.NavGraph
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.NavProviderFactory
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.Screens
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeeplinkManagerTheme
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryBackground
import com.ersinberkealemdaroglu.deeplinkmanager.util.DeeplinkIdManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeeplinkIdManager.init(this)
            StatusBarWithAttr()
            val navController = rememberNavController()
            val navProvider = NavProviderFactory.createNavProvider()

            DeeplinkManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = PrimaryBackground) { innerPadding ->
                    NavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        navProvider = navProvider,
                        startDestination = Screens.Home
                    )
                }
            }
        }
    }
}

@Composable
fun StatusBarWithAttr() {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }
}