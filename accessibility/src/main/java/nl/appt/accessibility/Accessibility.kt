package nl.appt.accessibility

import android.content.Context
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityManager
import androidx.core.content.ContextCompat
import androidx.core.view.accessibility.AccessibilityEventCompat
import java.util.*

/**
 * The Accessibility class contains all accessibility methods.
 *
 * Created by Jan Jaap de Groot on 02/07/2020.
 */
class Accessibility {

    companion object {
        // Empty
    }
}

/**
 * Returns the default language of the application
 *
 * @return Default language as ISO string
 */
fun Accessibility.Companion.getLanguage(): String {
    return Locale.getDefault().language
}

/**
 * Returns the default country of the application
 *
 * @return Default country as ISO string
 */
fun Accessibility.Companion.getCountry(): String {
    return Locale.getDefault().country
}

/**
 * Returns the AccessibilityManager if available and enabled.
 *
 * @param context Context reference
 *
 * @return AccessibilityManager object, or null
 */
fun Accessibility.Companion.getAccessibilityManager(context: Context?): AccessibilityManager? {
    if (context != null) {
        val service = ContextCompat.getSystemService(context, AccessibilityManager::class.java)
        if (service is AccessibilityManager && service.isEnabled) {
            return service
        }
    }
    return null
}

/**
 * Checks whether TalkBack is enabled
 *
 * @param context Context reference
 *
 * @return True when TalkBack is activated
 */
fun Accessibility.Companion.isTalkBackEnabled(context: Context?): Boolean {
    return getAccessibilityManager(context)?.isTouchExplorationEnabled ?: false
}

/**
 * Interrupts the assistive technology
 *
 * @param context Context reference
 */
fun Accessibility.Companion.interrupt(context: Context?) {
    getAccessibilityManager(context)?.interrupt()
}

/**
 * Announces the given message using the assistive technology
 *
 * @param context Context reference
 * @param message The message to announce
 */
fun Accessibility.Companion.announce(context: Context?, message: String) {
    getAccessibilityManager(context)?.let { accessibilityManager ->
        val type = AccessibilityEventCompat.TYPE_ANNOUNCEMENT

        val event = AccessibilityEvent.obtain(type)
        event.text.add(message)
        event.className = Context::class.java.name
        event.packageName = context?.packageName

        accessibilityManager.sendAccessibilityEvent(event)
    }
}

/**
 * Moves the accessibility focus to the given view
 *
 * @param view View to move accessibility focus to
 */
fun Accessibility.Companion.setFocus(view: View) {
    view.isFocusable = true
    view.requestFocus()
    view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
}

/**
 * Sets the given label to the given view
 *
 * @param view View to apply the label to
 * @param label The label to apply to the view
 */
fun Accessibility.Companion.setLabel(view: View, label: String) {
    view.contentDescription = label
}