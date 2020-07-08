package nl.appt.accessibility.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import nl.appt.accessibility.activity.accessibility
import nl.appt.accessibility.view.accessibility

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Announce a custom label and custom action on selection of textView1.
        textView1.accessibility.label = getString(R.string.textView1_label)
        textView1.accessibility.action = getString(R.string.textView1_action)

        // Custom traversal order: textView1, textView3, textView2
        accessibility.elements = arrayOf(textView1, textView3, textView2)

        textView3.accessibility.focus()
    }
}