package com.example.doctorappointmentapp

data class Doctor(
    val name: String,
    val specialization: String,
    val rating: Float,
    val image: Int,
    val certifications: String,
    val competencies: String,
    val languages: String,
    val clinicName: String? = null, // Optional
    val clinicAddress: String? = null, // Optional
    val clinicLatitude: Double? = null, // Optional
    val clinicLongitude: Double? = null // Optional
)
