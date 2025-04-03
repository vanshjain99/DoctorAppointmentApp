package com.example.doctorappointmentapp

data class Appointment(
    val id: Long,
    val date: String,
    val time: String,
    val appointmentType: String,
    val extraService: Boolean,
    val clinicWebsite: String,
    val clinicLocation: String
)
