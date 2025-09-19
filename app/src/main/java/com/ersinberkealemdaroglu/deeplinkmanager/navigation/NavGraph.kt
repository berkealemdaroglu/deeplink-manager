package com.ersinberkealemdaroglu.deeplinkmanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    navProvider: NavProvider,
    startDestination: Screens,
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        navProvider.screens.forEach { navScreen ->
            navScreen.screen.registerGraph(
                navGraphBuilder = this, navController = navController
            )
        }
    }
}