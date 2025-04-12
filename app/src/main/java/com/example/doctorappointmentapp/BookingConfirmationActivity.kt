package com.example.doctorappointmentapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_confirmation)

        val date = intent.getStringExtra("DATE")
        val time = intent.getStringExtra("TIME")
        val doctor = intent.getStringExtra("DOCTOR")
        val appointmentType = intent.getStringExtra("APPOINTMENT_TYPE")
        val extraService = intent.getStringExtra("EXTRA_SERVICE")

        findViewById<TextView>(R.id.confirmation_text).text = """
            Appointment confirmed with Dr. $doctor
            Appointment Type: $appointmentType
            Date: $date
            Time: $time
            Extra Service: $extraService
        """.trimIndent()
    }
}
