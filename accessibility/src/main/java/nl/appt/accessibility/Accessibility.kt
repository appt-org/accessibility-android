package nl.appt.accessibility

import android.content.Context
import java.util.*

/**
 * Created by Jan Jaap de Groot on 02/07/2020.
 */
class Accessibility {

    companion object {
        fun test() {
            println("Test")
        }

        fun getLanguage(): String {
            return Locale.getDefault().language
        }

        fun getCountry(): String {
            return Locale.getDefault().country
        }
    }
}