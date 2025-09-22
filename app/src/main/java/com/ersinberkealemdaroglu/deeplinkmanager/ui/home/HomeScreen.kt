package com.ersinberkealemdaroglu.deeplinkmanager.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ersinberkealemdaroglu.deeplinkmanager.R
import com.ersinberkealemdaroglu.deeplinkmanager.model.DeeplinkModel
import com.ersinberkealemdaroglu.deeplinkmanager.ui.component.CustomToolbar
import com.ersinberkealemdaroglu.deeplinkmanager.ui.component.PrimaryButton
import com.ersinberkealemdaroglu.deeplinkmanager.ui.component.TextFiledGetirir
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeeplinkManagerTheme
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.HorizontalDividerColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryBackground
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.SecondaryTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.util.noRippleClickable

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUIState,
    onNewDeeplinkButtonClicked: () -> Unit,
    onItemClicked: (deeplink: String) -> Unit = {},
    onInfoClicked: (deeplinkModel: DeeplinkModel) -> Unit = {},
    onCopyText: (String) -> Unit,
    onSearchText: (String) -> Unit = {},
) {
    var deeplinkText by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        if (uiState.uiModelState == HomeScreenUIModelState.NO_DATA) {
            NoData(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp), onClickButton = onNewDeeplinkButtonClicked
            )
        } else {
            CustomToolbar(
                modifier = Modifier.fillMaxWidth(),
                title = "Deeplink Manager",
            )

            HorizontalDivider(
                thickness = 1.5.dp, color = HorizontalDividerColor
            )

            Spacer(Modifier.height(16.dp))

            TextFiledGetirir(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), text = deeplinkText, trailingIcon = {
                if (deeplinkText.isNotEmpty()) {
                    Image(
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                            .noRippleClickable {
                                deeplinkText = ""
                            }, painter = painterResource(R.drawable.ic_close_icon), contentDescription = null
                    )
                }
            }, placeholder = "Enter a title for the deeplink", onValueChange = { text ->
                deeplinkText = text
            })

            Spacer(Modifier.height(16.dp))

            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "Open Deeplink",
                enabled = deeplinkText.isNotEmpty(),
                onClick = {
                    onItemClicked.invoke(deeplinkText)
                })

            Spacer(Modifier.height(16.dp))

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp), thickness = 1.5.dp, color = HorizontalDividerColor
            )

            Spacer(Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Saved Deeplinks",
                style = MaterialTheme.typography.bodyLarge,
                color = PrimaryTextColor,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(16.dp))

            TextFiledGetirir(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = uiState.searchText,
                trailingIcon = {
                    if (uiState.searchText.isNotEmpty()) {
                        Image(
                            modifier = Modifier
                                .width(16.dp)
                                .height(16.dp)
                                .noRippleClickable {
                                    onSearchText.invoke("")
                                }, painter = painterResource(R.drawable.ic_close_icon), contentDescription = null
                        )
                    }
                },
                placeholder = "Search saved deeplinks",
                onValueChange = { text ->
                    onSearchText.invoke(text)
                })

            Spacer(Modifier.height(8.dp))

            DeeplinkListUi(modifier = Modifier.fillMaxSize(), uiState = uiState, onItemClicked = { deeplink ->
                onItemClicked.invoke(deeplink)
            }, onInfoClicked = { id ->
                onInfoClicked.invoke(id)
            }, onCopyText = { deeplink ->
                onCopyText.invoke(deeplink)
            }, onNewDeeplinkButtonClicked = {
                onNewDeeplinkButtonClicked.invoke()
            })
        }
    }
}

@Composable
private fun NoData(modifier: Modifier = Modifier, onClickButton: () -> Unit = {}) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp),
            alignment = Alignment.Center,
            painter = painterResource(R.drawable.ic_icon),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome to Deeplink Manager",
            style = MaterialTheme.typography.headlineLarge,
            color = PrimaryTextColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Effortlessly manage and access your deep links with our intuitive app.",
            style = MaterialTheme.typography.titleMedium,
            color = SecondaryTextColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        PrimaryButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(), text = "Add New Deeplink", onClick = {
                onClickButton.invoke()
            })

    }
}

@Composable
private fun DeeplinkListUi(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUIState,
    onItemClicked: (deeplink: String) -> Unit = {},
    onInfoClicked: (deeplinkModel: DeeplinkModel) -> Unit = {},
    onCopyText: (String) -> Unit,
    onNewDeeplinkButtonClicked: () -> Unit = {},
) {
    Column(modifier) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(uiState.deeplinkList.reversed()) { index, item ->
                DeeplinkItem(modifier = Modifier.fillMaxWidth(), deeplinkModel = item, onCopyText = { deeplink ->
                    onCopyText.invoke(deeplink)

                }, onItemClicked = {
                    onItemClicked.invoke(item.url)
                }, onInfoClicked = {
                    onInfoClicked.invoke(item)
                })

                if (index != uiState.deeplinkList.lastIndex) {
                    Spacer(Modifier.height(8.dp))
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp), thickness = 1.5.dp, color = HorizontalDividerColor
                    )
                }
            }
        }

        HorizontalDivider(
            thickness = 1.5.dp, color = HorizontalDividerColor
        )

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp), text = "Add New Deeplink", onClick = {
                onNewDeeplinkButtonClicked.invoke()
            })
    }
}

@Composable
private fun DeeplinkItem(
    modifier: Modifier = Modifier,
    deeplinkModel: DeeplinkModel,
    onItemClicked: () -> Unit = {},
    onInfoClicked: () -> Unit = {},
    onCopyText: (deeplink: String) -> Unit = {},
) {
    Row(modifier = modifier
        .noRippleClickable {
            onItemClicked.invoke()
        }
        .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .padding(16.dp),
            painter = painterResource(R.drawable.ic_deeplink_item_icon),
            contentDescription = null
        )
        Column(
            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = deeplinkModel.title,
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryTextColor,
                textAlign = TextAlign.Start,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = deeplinkModel.url,
                style = MaterialTheme.typography.titleSmall,
                color = SecondaryTextColor,
                textAlign = TextAlign.Start,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Spacer(Modifier.width(8.dp))

        Image(
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .noRippleClickable {
                    onCopyText.invoke(deeplinkModel.url)
                }, painter = painterResource(R.drawable.ic_copy_icon), contentDescription = null
        )

        Spacer(Modifier.width(8.dp))

        Image(
            modifier = Modifier
                .width(16.dp)
                .noRippleClickable {
                    onInfoClicked.invoke()
                }, painter = painterResource(R.drawable.ic_info_icon), contentDescription = null
        )
        Spacer(Modifier.width(16.dp))
    }
}

@Preview(device = Devices.PIXEL_2_XL, showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    DeeplinkManagerTheme {
        HomeScreen(
            Modifier
                .background(PrimaryBackground)
                .fillMaxSize()
                .padding(horizontal = 16.dp), uiState = HomeScreenUIState(
            deeplinkList = listOf(
                DeeplinkModel(
                    id = 1,
                    title = "Kredi Banka Kartı",
                    url = "paycellapp://deeplink?screenId=19824&isPresenting=1",
                )
            )
        ), onNewDeeplinkButtonClicked = {}, onCopyText = {})
    }
}

@Preview(device = Devices.PIXEL_2_XL, showSystemUi = true, backgroundColor = 0xFF101922)
@Composable
private fun PreviewHomeScreenDeeplinkListItem() {
    DeeplinkManagerTheme {
        DeeplinkItem(
            deeplinkModel = DeeplinkModel(
                id = 1,
                title = "Kredi Banka Kartı",
                url = "paycellapp://deeplink?screenId=19824&isPresenting=1",
            )
        )
    }
}