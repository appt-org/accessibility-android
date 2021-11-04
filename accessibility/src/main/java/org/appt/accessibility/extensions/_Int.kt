package org.appt.accessibility.extensions

/**
 * Created by Jan Jaap de Groot on 31/03/2021
 * Copyright 2021 Stichting Appt
 */

fun Int.toHex(): String {
    return String.format("#%06X", 0xFFFFFF and this)
}