package com.example.doctorappointmentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.widget.Toast
class DoctorProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_profile)

        // Get the data passed from the DoctorAdapter
        val doctorImage = intent.getIntExtra("doctor_image", R.drawable.doctor1)
        val doctorName = intent.getStringExtra("doctor_name")
        val doctorSpecialization = intent.getStringExtra("doctor_specialization")
        val doctorRating = intent.getFloatExtra("doctor_rating", 0.0f)
        val doctorCertifications = intent.getStringExtra("doctor_certifications")
        val doctorCompetencies = intent.getStringExtra("doctor_competencies")
        val doctorLanguages = intent.getStringExtra("doctor_languages")
        val clinicName = intent.getStringExtra("clinic_name")
        val clinicAddress = intent.getStringExtra("clinic_address")

        // Initialize views
        val doctorImageView: ImageView = findViewById(R.id.doctorImage)
        val doctorNameText: TextView = findViewById(R.id.doctorName)
        val doctorSpecializationText: TextView = findViewById(R.id.doctorSpecialization)
        val doctorRatingBar: RatingBar = findViewById(R.id.doctorRating)
        val doctorCertificationsText: TextView = findViewById(R.id.doctorCertifications)
        val doctorCompetenciesText: TextView = findViewById(R.id.doctorCompetencies)
        val doctorLanguagesText: TextView = findViewById(R.id.doctorLanguages)
        val clinicInfoText: TextView = findViewById(R.id.clinicInfo)
        val bookAppointmentButton: Button = findViewById(R.id.bookAppointmentButton)

        // Set the values to the views
        doctorImageView.setImageResource(doctorImage)
        doctorNameText.text = doctorName
        doctorSpecializationText.text = doctorSpecialization
        doctorRatingBar.rating = doctorRating
        doctorCertificationsText.text = "Certifications: $doctorCertifications"
        doctorCompetenciesText.text = "Competencies: $doctorCompetencies"
        doctorLanguagesText.text = "Languages: $doctorLanguages"
        clinicInfoText.text = "Clinic: $clinicName\nAddress: $clinicAddress"

        // Book Appointment Button action
        bookAppointmentButton.setOnClickListener {
            // Open a new activity or fragment to book an appointment (e.g., AppointmentActivity)
            val intent = Intent(this, AppointmentActivity::class.java)
            intent.putExtra("doctor_name", doctorName)
            intent.putExtra("doctor_specialization", doctorSpecialization)
            startActivity(intent)
        }

        val clinicTextView = findViewById<TextView>(R.id.clinicInfo)
        clinicTextView.setOnClickListener {
            val clinicAddress = "123 Heart Ave, City"
            val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(clinicAddress))
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }



    }
}
