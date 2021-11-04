package org.appt.accessibility.settings

import android.content.ContentResolver
import android.provider.Settings
import java.lang.reflect.Modifier

/**
 * Created by Jan Jaap de Groot on 31/03/2021
 * Copyright 2021 Stichting Appt
 */
data class Settings(@Transient private val contentResolver: ContentResolver) {

    val global = getSettings(Settings.Global::class.java)
    val secure = getSettings(Settings.Secure::class.java)
    val system = getSettings(Settings.System::class.java)

    private fun <T: Settings.NameValueTable> getSettings(clazz: Class<T>): Map<String, Any?> {
        val fields = clazz.declaredFields

        val keys = fields.filter { field ->
            Modifier.isStatic(field.modifiers) && Modifier.isPublic(field.modifiers)
        }.mapNotNull { field ->
            try {
                val data = field.get(clazz)
                if (data::class.java.name.contains("java.lang.String")) {
                    data.toString()
                } else {
                    null
                }
            } catch (e: IllegalAccessException) {
                // Ignored
                null
            }
        }

        val map = mutableMapOf<String, Any?>()

        clazz.declaredMethods.firstOrNull() {
            it.name.contains("getString")
        }?.let { method ->
            for (key in keys) {
                try {
                    val value = method.invoke(clazz, contentResolver, key)
                    map[key] = value
                } catch (e: Exception) {
                    // Ignored
                }
            }
        }

        return map
    }
}