package nl.appt.accessibility.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Jan Jaap de Groot on 31/03/2021
 * Copyright 2021 Stichting Appt
 */

fun <T> T.toMap(): Map<String, Any> {
    return convert()
}

inline fun <reified T> Map<String, Any>.toDataClass(): T {
    return convert()
}

inline fun <I, reified O> I.convert(): O {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, object : TypeToken<O>() {}.type)
}