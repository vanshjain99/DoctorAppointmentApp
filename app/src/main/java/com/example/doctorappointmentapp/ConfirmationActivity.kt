package com.example.doctorappointmentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val date = intent.getStringExtra("DATE")
        val time = intent.getStringExtra("TIME")
        val appointmentType = intent.getStringExtra("APPOINTMENT_TYPE")
        val extraService = intent.getBooleanExtra("EXTRA_SERVICE", false)

        val confirmationText = findViewById<TextView>(R.id.confirmation_text)
        val dashboardButton = findViewById<Button>(R.id.dashboard_button)

        val extraServiceText = if (extraService) "Yes" else "No"
        confirmationText.text = """
            Appointment Confirmed!
            
            Date: $date
            Time: $time
            Type: $appointmentType
            Additional Services: $extraServiceText
        """.trimIndent()

        dashboardButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, DashboardFragment())
            transaction.addToBackStack(null)  // Optional: Add the transaction to the back stack if you want back navigation
            transaction.commit()
        }
    }
}

