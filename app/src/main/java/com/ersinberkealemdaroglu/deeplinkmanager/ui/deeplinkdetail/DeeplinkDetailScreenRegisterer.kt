package com.ersinberkealemdaroglu.deeplinkmanager.ui.deeplinkdetail

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ersinberkealemdaroglu.deeplinkmanager.model.DeeplinkModel
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.NavRegisterer
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.Screens
import com.ersinberkealemdaroglu.deeplinkmanager.ui.home.DeeplinkSharedViewModel
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryBackground

class DeeplinkDetailScreenRegisterer : NavRegisterer {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
    ) {
        navGraphBuilder.composable<Screens.DeeplinkDetail> { navArgument ->
            val context = LocalContext.current
            val viewModel = remember {
                DeeplinkSharedViewModel(context.applicationContext as Application)
            }
            val argument = navArgument.toRoute<Screens.DeeplinkDetail>()
            val deeplinkModel = DeeplinkModel(
                id = argument.id, title = argument.title, url = argument.url
            )

            DeeplinkDetailScreen(modifier = Modifier
                .background(PrimaryBackground)
                .fillMaxSize(), onBackButtonClicked = {
                navController.popBackStack()
            }, deeplinkModel = deeplinkModel, onSaveDeeplinkButtonClicked = { title, url ->
                viewModel.updateDeeplinkData(
                    DeeplinkModel(
                        id = argument.id, title = title, url = url
                    )
                )
                navController.popBackStack()
            }, onDeleteDeeplinkButtonClicked = {
                viewModel.removeDeeplinkData(deeplinkModel)
                navController.popBackStack()
            })
        }

    }
}