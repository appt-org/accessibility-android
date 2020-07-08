package nl.appt.accessibility.view

import android.view.View
import nl.appt.accessibility.*

/**
 * This class contains accessibility extensions for View.
 *
 * Created by Jan Jaap de Groot on 02/07/2020.
 */
class AccessibleView(private val view: View) {

    /**
     * Getter/setter for accessibility label
     */
    var label: CharSequence?
        get() = view.contentDescription
        set(value) {
            view.contentDescription = value
        }

    /**
     * Sets the accessibility label to the given resource
     *
     * @param resId String resource identifier
     */
    fun setLabel(resId: Int) {
        label = view.context.getString(resId)
    }


    /**
     * Setter for accessibility action
     */
    var action: String?
        get() = null
        set(value) {
            value?.let { action ->
                Accessibility.setAction(view, action)
            }
        }

    /**
     * Sets the accessibility action to the given resource
     *
     * @param resId String resource identifier
     */
    fun setAction(resId: Int) {
        action = view.context.getString(resId)
    }


    /**
     * Sets traversal information for the current view.
     *
     * @param before View to traverse beforehand
     * @param after View to traverse afterwards
     */
    fun traversal(before: View? = null, after: View? = null) {
        Accessibility.setTraversal(view, before = before, after = after)
    }

    /**
     * Sets the current view to be traversed before the given `before` view.
     *
     * @param before View to traverse beforehand
     */
    fun traversalBefore(before: View) {
        Accessibility.setTraversalBefore(view, before)
    }

    /**
     * Sets the current view to be traversed after the given `after` view.
     *
     * @param after View to traverse afterwards
     */
    fun traversalAfter(after: View) {
        Accessibility.setTraversalAfter(view, after)
    }


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
     * Moves the accessibility focus to the current view
     */
    fun focus() {
        Accessibility.setFocus(view)
    }
}

// Adds the `accessibility` field to all classes which inherit from View.
var View.accessibility: AccessibleView
    get() = AccessibleView(this)
    set(value) {
        // Ignored
    }