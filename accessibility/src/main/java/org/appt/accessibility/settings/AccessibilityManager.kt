package org.appt.accessibility.settings

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.os.Build
import android.view.accessibility.AccessibilityManager
import androidx.annotation.RequiresApi

/**
 * Created by Jan Jaap de Groot on 31/03/2021
 * Copyright 2021 Stichting Appt
 */
data class AccessibilityManager(@Transient private val context: Context) {

    @Transient private val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

    val isAccessibilityButtonSupported = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
        AccessibilityManager.isAccessibilityButtonSupported()
    } else {
        null
    }
    val isEnabled = accessibilityManager.isEnabled
    val isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled
    val installedAccessibilityServiceList = getPackages(accessibilityManager.installedAccessibilityServiceList)
    val enabledAccessibilityServiceList = getPackages(accessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK))
    val timeoutMultiplierForControls = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        getTimeoutMultiplier(AccessibilityManager.FLAG_CONTENT_CONTROLS)
    } else {
        null
    }
    val timeoutMultiplierForIcons = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        getTimeoutMultiplier(AccessibilityManager.FLAG_CONTENT_ICONS)
    } else {
        null
    }
    val timeoutMultiplierForText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        getTimeoutMultiplier(AccessibilityManager.FLAG_CONTENT_TEXT)
    } else {
        null
    }

    private fun getPackages(services: List<AccessibilityServiceInfo>): List<String> {
        return services.map {
            it.resolveInfo.serviceInfo.packageName
        }.distinct()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun getTimeoutMultiplier(flag: Int): Double? {
        return accessibilityManager.getRecommendedTimeoutMillis(1000, flag) / 1000.0
    }
}