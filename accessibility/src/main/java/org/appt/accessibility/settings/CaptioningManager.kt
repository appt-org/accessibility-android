package org.appt.accessibility.settings

import android.content.Context
import android.view.accessibility.CaptioningManager
import android.view.accessibility.CaptioningManager.CaptionStyle
import org.appt.accessibility.extensions.toHex

/**
 * Created by Jan Jaap de Groot on 31/03/2021
 * Copyright 2021 Stichting Appt
 */
data class CaptioningManager(@Transient private val context: Context) {

    @Transient private val captioningManager = context.getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

    val fontScale = captioningManager.fontScale
    val isEnabled = captioningManager.isEnabled
    val locale = captioningManager.locale
    val userStyle = UserStyle(captioningManager.userStyle)

    data class UserStyle(@Transient private val style: CaptionStyle) {
        val backgroundColor = style.backgroundColor.toHex()
        val edgeColor = style.edgeColor.toHex()
        val edgeType = style.edgeType
        val foregroundColor = style.foregroundColor.toHex()
        val hasBackgroundColor = style.hasBackgroundColor()
        val hasEdgeColor = style.hasEdgeColor()
        val hasEdgeType = style.hasEdgeType()
        val hasForegroundColor = style.hasForegroundColor()
        val hasWindowColor = style.hasWindowColor()
        val typeface = style.typeface
        val windowColor = style.windowColor.toHex()
    }
}