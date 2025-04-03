package com.example.doctorappointmentapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.content.Intent
import android.util.Log


class AppointmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        val datePicker = findViewById<EditText>(R.id.date_picker)
        val timePicker = findViewById<EditText>(R.id.time_picker)
        val appointmentTypeGroup = findViewById<RadioGroup>(R.id.appointment_type_group)
        val extraServiceCheckbox = findViewById<CheckBox>(R.id.extra_service_checkbox)
        val bookButton = findViewById<Button>(R.id.book_appointment_button)

        // Set up Date Picker Dialog
        datePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                datePicker.setText("$dayOfMonth/${month + 1}/$year") // Set selected date
            }
            val datePickerDialog = DatePickerDialog(
                this,
                dateListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }

        // Set up Time Picker Dialog
        timePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timeListener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                timePicker.setText("$hourOfDay:$minute") // Set selected time
            }
            val timePickerDialog = TimePickerDialog(
                this,
                timeListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePickerDialog.show()
        }

        // Create an instance of AppointmentDatabaseHelper
        val dbHelper = AppointmentDatabaseHelper(this)

        bookButton.setOnClickListener {
            val date = datePicker.text.toString()
            val time = timePicker.text.toString()
            val appointmentType = when (appointmentTypeGroup.checkedRadioButtonId) {
                R.id.radio_online -> "Online"
                R.id.radio_in_person -> "In Person"
                else -> ""
            }
            val extraService = extraServiceCheckbox.isChecked

            // Validation to ensure all fields are filled
            if (date.isEmpty() || time.isEmpty() || appointmentType.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create an instance of AppointmentDatabaseHelper
            val dbHelper = AppointmentDatabaseHelper(this)

            // Example values for clinic website and location
            val clinicWebsite = "https://www.exampleclinic.com"
            val clinicLocation = "123 Main Street, City, Country"

            try {
                // Insert appointment into the database
                val appointmentId = dbHelper.insertAppointment(date, time, appointmentType, extraService, clinicWebsite, clinicLocation)

                if (appointmentId != -1L) {
                    Toast.makeText(this, "Appointment booked successfully", Toast.LENGTH_SHORT).show()

                    // Send data to ConfirmationActivity
                    val intent = Intent(this, ConfirmationActivity::class.java)
                    intent.putExtra("DATE", date)
                    intent.putExtra("TIME", time)
                    intent.putExtra("APPOINTMENT_TYPE", appointmentType)
                    intent.putExtra("EXTRA_SERVICE", extraService)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error booking appointment", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("AppointmentActivity", "Error booking appointment", e)
                Toast.makeText(this, "Exception: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
