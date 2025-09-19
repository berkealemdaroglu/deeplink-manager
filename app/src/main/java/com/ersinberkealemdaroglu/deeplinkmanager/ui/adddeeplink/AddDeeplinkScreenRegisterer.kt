package com.ersinberkealemdaroglu.deeplinkmanager.ui.adddeeplink

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ersinberkealemdaroglu.deeplinkmanager.model.DeeplinkModel
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.NavRegisterer
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.Screens
import com.ersinberkealemdaroglu.deeplinkmanager.ui.home.DeeplinkSharedViewModel
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryBackground
import com.ersinberkealemdaroglu.deeplinkmanager.util.DeeplinkIdManager.getNextId

class AddDeeplinkScreenRegisterer : NavRegisterer {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
    ) {
        navGraphBuilder.composable<Screens.AddDeeplink> {
            val context = LocalContext.current
            val viewModel = remember {
                DeeplinkSharedViewModel(context.applicationContext as Application)
            }

            AddDeeplinkScreen(modifier = Modifier
                .background(PrimaryBackground)
                .fillMaxSize(), onBackButtonClicked = {
                navController.popBackStack()
            }, onSaveDeeplinkButtonClicked = { title, url ->
                viewModel.saveDeeplinkData(
                    DeeplinkModel(
                        id = getNextId(context), title = title, url = url
                    )
                )
                navController.popBackStack()
            })
        }
    }
}