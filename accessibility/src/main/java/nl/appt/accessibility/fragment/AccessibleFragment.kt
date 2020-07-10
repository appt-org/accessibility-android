package nl.appt.accessibility.fragment

import android.app.Fragment
import android.view.View
import nl.appt.accessibility.activity.accessibility

/**
 * This class contains accessibility extensions for Activity.
 *
 * Created by Jan Jaap de Groot on 08/07/2020.
 */
class AccessibleFragment(private val fragment: Fragment) {

    /**
     * Setter for traversal order
     */
    var elements: Array<View>?
        get() = null
        set(value) {
            fragment.activity?.accessibility?.elements = elements
        }


    /**
     * Announces the given message using the assistive technology
     *
     * @param message The message to announce
     */
    fun announce(message: String) {
        fragment.activity?.accessibility?.announce(message)
    }


    /**
     * Interrupts the assistive technology
     */
    fun interrupt() {
        fragment.activity?.accessibility?.interrupt()
    }
}

// Adds the `accessibility` field to all classes which inherit from Fragment.
var Fragment.accessibility: AccessibleFragment
    get() = AccessibleFragment(this)
    set(value) {
        // Ignored
    }