package com.ersinberkealemdaroglu.deeplinkmanager.util

import android.content.Context
import androidx.core.content.edit
import java.util.concurrent.atomic.AtomicInteger

object DeeplinkIdManager {
    private const val PREFS_NAME = "deeplink_id_prefs"
    private const val KEY_LAST_ID = "last_id"

    private val idCounter = AtomicInteger(0)

    fun init(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val lastSavedId = prefs.getInt(KEY_LAST_ID, 0)
        idCounter.set(lastSavedId)
    }

    fun getNextId(context: Context): Int {
        val newId = idCounter.incrementAndGet()

        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit {
            putInt(KEY_LAST_ID, newId)
        }

        return newId
    }
}