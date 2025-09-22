package com.ersinberkealemdaroglu.deeplinkmanager.ui.home

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.NavRegisterer
import com.ersinberkealemdaroglu.deeplinkmanager.navigation.Screens
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryBackground

class HomeScreenRegisterer : NavRegisterer {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
    ) {
        navGraphBuilder.composable<Screens.Home> {
            val context = LocalContext.current
            val viewModel = remember {
                DeeplinkSharedViewModel(context.applicationContext as Application)
            }
            val uiState by viewModel.homeUiState.collectAsStateWithLifecycle()

            HomeScreen(
                modifier = Modifier
                    .background(PrimaryBackground)
                    .fillMaxSize(),
                uiState = uiState,
                onNewDeeplinkButtonClicked = {
                    navController.navigate(Screens.AddDeeplink)
                },
                onItemClicked = { deeplink ->
                    val uri = deeplink.trim().toUri()
                    val intent = Intent(Intent.ACTION_VIEW, uri)

                    try {
                        context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "App Not Found", Toast.LENGTH_SHORT).show()
                    }
                },
                onCopyText = { deeplink ->
                    copyText(text = deeplink, context)
                },
                onInfoClicked = { deeplinkModel ->
                    navController.navigate(
                        route = Screens.DeeplinkDetail(
                            id = deeplinkModel.id, title = deeplinkModel.title, url = deeplinkModel.url
                        )
                    )
                },
                onSearchText = { searchText ->
                    viewModel.onSearchTextChange(searchText)
                })
        }
    }

    private fun copyText(text: String? = null, context: Context) {
        val clipboard: ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
    }
}