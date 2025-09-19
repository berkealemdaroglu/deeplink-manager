package com.ersinberkealemdaroglu.deeplinkmanager.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class DeeplinkModel(
    val id: Int,
    val title: String,
    val url: String,
) : Parcelable