package com.example.doctorappointmentapp

data class Doctor(
    val name: String,
    val specialization: String,
    val rating: Float,
    val image: Int,
    val certifications: String,
    val competencies: String,
    val languages: String,
    val clinicName: String? = null,
    val clinicAddress: String? = null,
    val clinicLatitude: Double? = null,
    val clinicLongitude: Double? = null
)
