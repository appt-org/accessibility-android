package nl.appt.accessibility.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import nl.appt.accessibility.Analytics
import nl.appt.accessibility.activity.accessibility
import nl.appt.accessibility.getSettings
import nl.appt.accessibility.view.accessibility
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Set a custom label to textView1.
        textView1.accessibility.label = getString(R.string.textView1_label)

        // Set a custom action to textView1.
        textView1.accessibility.action = getString(R.string.textView1_action)

        // Custom traversal order: textView1, textView3, textView2.
        accessibility.elements = arrayOf(textView1, textView3, textView2)

        // Analytics
        val settings = Analytics.getSettings(this)
        Log.d("Analytics", JSONObject(settings).toString())
    }
}