package nl.appt.accessibility

import android.view.View
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

/**
 * This file contains accessibility action related methods.
 *
 * Created by Jan Jaap de Groot on 02/07/2020.
 */

/**
 * Adds an AccessibilityAction of the given type to the given view
 *
 * @param view The view to set the action to
 * @param type Type of the action, listed in AccessibilityNodeInfoCompat
 * @param description Short description of the action
 *
 * @see androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 */
fun Accessibility.Companion.setAction(view: View, type: Int, description: String) {
    ViewCompat.setAccessibilityDelegate(view, object : AccessibilityDelegateCompat() {
        override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(host, info)

            val action = AccessibilityNodeInfoCompat.AccessibilityActionCompat(type, description)
            info.addAction(action)
        }
    })
}

/**
 * Adds an AccessibilityAction of the given type to the given view
 *
 * @param view The view to set the action to
 * @param type Type of the action, listed in AccessibilityNodeInfoCompat
 * @param description Resource describing the action
 *
 * @see androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 */
fun Accessibility.Companion.setAction(view: View, type: Int, description: Int) {
    Accessibility.setAction(view, type, view.context.getString(description))
}


/**
 * Adds a click action to the given view
 *
 * @param view The view to set the action to
 * @param action Short description of the action
 */
fun Accessibility.Companion.setAction(view: View, action: String) {
    Accessibility.setAction(view, AccessibilityNodeInfoCompat.ACTION_CLICK, action)
}

/**
 * Adds a click action to the given view
 *
 * @param view The view to set the action to
 * @param action Resource describing the action
 */
fun Accessibility.Companion.setAction(view: View, action: Int) {
    Accessibility.setAction(view, AccessibilityNodeInfoCompat.ACTION_CLICK, action)
}


/**
 * Adds an accessibility action
 *
 * @param action Short description of the action
 */
fun View.setAccessibilityAction(action: String) {
    Accessibility.setAction(this, action)
}

/**
 * Adds an accessibility action
 *
 * @param action Resource describing the action
 */
fun View.setAccessibilityAction(action: Int) {
    Accessibility.setAction(this, action)
}