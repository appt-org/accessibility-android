package org.appt.accessibility.activity

import android.app.Activity
import android.view.View
import org.appt.accessibility.*

/**
 * This class contains accessibility extensions for Activity.
 *
 * Created by Jan Jaap de Groot on 08/07/2020.
 */
class AccessibleActivity(private val activity: Activity) {

    /**
     * Setter for traversal order
     */
    var elements: Array<View>?
        get() = null
        set(value) {
            value?.let { views ->
                Accessibility.setTraversalOrder(*views)
            }
        }


    /**
     * Announces the given message using the assistive technology
     *
     * @param message The message to announce
     */
    fun announce(message: String) {
        Accessibility.announce(activity, message)
    }


    /**
     * Interrupts the assistive technology
     */
    fun interrupt() {
        Accessibility.interrupt(activity)
    }
}

// Adds the `accessibility` field to all classes which inherit from Activity.
var Activity.accessibility: AccessibleActivity
    get() = AccessibleActivity(this)
    set(value) {
        // Ignored
    }