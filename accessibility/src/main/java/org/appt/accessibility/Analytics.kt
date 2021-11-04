package org.appt.accessibility

import android.content.Context
import org.appt.accessibility.extensions.toMap
import org.appt.accessibility.settings.AccessibilityManager
import org.appt.accessibility.settings.CaptioningManager
import org.appt.accessibility.settings.Configuration
import org.appt.accessibility.settings.Settings

/**
 * The Accessibility class contains all analytics methods.
 *
 * Created by Jan Jaap de Groot on 30/03/2021
 * Copyright 2021 Stichting Appt
 */
class Analytics {

    companion object {
        // Empty
    }
}

/**
 * Returns a map containing all accessibility settings
 *
 * @return Map containing all accessibility settings
 */
fun Analytics.Companion.getSettings(context: Context): Map<String, Any?> {
    val map = mutableMapOf<String, Any>()

    map["accessibilityManager"] = AccessibilityManager(context).toMap()
    map["captioningManager"] = CaptioningManager(context).toMap()
    map["configuration"] = Configuration(context.resources.configuration).toMap()
    map["settings"] = Settings(context.contentResolver).toMap()

    return map
}