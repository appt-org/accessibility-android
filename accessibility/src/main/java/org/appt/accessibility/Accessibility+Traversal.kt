package org.appt.accessibility

import android.view.View
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

/**
 * This file contains accessibility traversal related methods.
 *
 * Created by Jan Jaap de Groot on 02/07/2020.
 */

/**
 * Sets traversal information for the given view.
 *
 * @param view View to apply traversal information to
 * @param before View to traverse beforehand
 * @param after View to traverse afterwards
 */
fun Accessibility.Companion.setTraversal(view: View, before: View? = null, after: View? = null) {
    ViewCompat.setAccessibilityDelegate(view, object : AccessibilityDelegateCompat() {
        override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfoCompat?) {
            before?.let { before ->
                info?.setTraversalBefore(before)
            }
            after?.let { after ->
                info?.setTraversalAfter(after)
            }
            super.onInitializeAccessibilityNodeInfo(host, info)
        }
    })
}

/**
 * Sets the given `view` to be traversed before the given `before` view.
 *
 * @param view View to apply traversal information to
 * @param before View to traverse beforehand
 */
fun Accessibility.Companion.setTraversalBefore(view: View, before: View) {
    Accessibility.setTraversal(view, before = before)
}

/**
 * Sets the given `view` to be traversed after the given `after` view.
 *
 * @param view The view to apply traversal information to
 * @param after View to traverse afterwards
 */
fun Accessibility.Companion.setTraversalAfter(view: View, after: View) {
    Accessibility.setTraversal(view, after = after)
}

/**
 * Sets the given `views` to be traversed in chronological order.
 *
 * @param views The view order to apply
 */
fun Accessibility.Companion.setTraversalOrder(vararg views: View) {
    if (views.size > 1) {
        for (i in 0..views.size-2) {
            Accessibility.setTraversalBefore(views[i], views[i+1])
        }
    }
}
