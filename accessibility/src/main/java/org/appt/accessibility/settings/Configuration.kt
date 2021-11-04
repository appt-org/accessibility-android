package org.appt.accessibility.settings

import android.content.res.Configuration
import android.os.Build

/**
 * Created by Jan Jaap de Groot on 31/03/2021
 * Copyright 2021 Stichting Appt
 */
data class Configuration(@Transient private val configuration: Configuration) {

    val colorMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        configuration.colorMode
    } else {
        null
    }
    val densityDpi = configuration.densityDpi
    val fontScale = configuration.fontScale
    val hardKeyboardHidden = configuration.hardKeyboardHidden
    val isNightModeActive = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        configuration.isNightModeActive
    } else {
        null
    }
    val isScreenHdr = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        configuration.isScreenHdr
    } else {
        null
    }
    val isScreenRound = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        configuration.isScreenRound
    } else {
        null
    }
    val isScreenWideColorGamut = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        configuration.isScreenWideColorGamut
    } else {
        null
    }
    val keyboard = configuration.keyboard
    val keyboardHidden = configuration.keyboardHidden
    val layoutDirection = configuration.layoutDirection
    val locale  = configuration.locale
    val locales = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        configuration.locales
    } else {
        null
    }
    val mcc = configuration.mcc
    val mnc = configuration.mnc
    val navigation = configuration.navigation
    val navigationHidden = configuration.navigationHidden
    val orientation = Orientation.from(configuration)
    val screenHeightDp = configuration.screenHeightDp
    val screenLayout = configuration.screenLayout
    val screenWidthDp = configuration.screenWidthDp
    val smallestScreenWidthDp = configuration.smallestScreenWidthDp
    val touchscreen = configuration.touchscreen
    val uiMode = UIMode.from(configuration)

    enum class Orientation(val identifier: Int) {
        PORTRAIT(Configuration.ORIENTATION_PORTRAIT),
        LANDSCAPE(Configuration.ORIENTATION_LANDSCAPE),
        SQUARE(Configuration.ORIENTATION_SQUARE),
        UNKNOWN(-1);

        companion object {
            fun from(configuration: Configuration): Orientation {
                val identifier = configuration.orientation
                return values().find { it.identifier == identifier } ?: UNKNOWN
            }
        }
    }

    enum class UIMode(val identifier: Int) {
        LIGHT(Configuration.UI_MODE_NIGHT_YES),
        DARK(Configuration.UI_MODE_TYPE_NORMAL),
        UNKNOWN(-1);

        companion object {
            fun from(configuration: Configuration): UIMode {
                val flags = configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)
                return when (flags) {
                    Configuration.UI_MODE_NIGHT_NO -> LIGHT
                    Configuration.UI_MODE_NIGHT_YES -> DARK
                    else -> UNKNOWN
                }
            }
        }
    }
}