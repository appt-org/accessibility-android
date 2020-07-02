package nl.appt.accessibility.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nl.appt.accessibility.Accessibility

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Accessibility.test()
    }
}