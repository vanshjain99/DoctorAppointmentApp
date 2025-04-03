package com.example.doctorappointmentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    private lateinit var dbHelper: AppointmentDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment's layout
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Initialize the database helper
        dbHelper = AppointmentDatabaseHelper(requireContext())

        // Retrieve the list of appointments from SQLite
        val appointments = dbHelper.getAllAppointments()

        // Set up a ListView to display the appointments
        val listView: ListView = view.findViewById(R.id.appointment_list)

        // Create an adapter for the ListView using a custom layout
        val adapter = AppointmentAdapter(appointments)
        listView.adapter = adapter

        // Handle the case when there are no appointments
        if (appointments.isEmpty()) {
            val noAppointmentsText = view.findViewById<TextView>(R.id.no_appointments_text)
            noAppointmentsText.visibility = View.VISIBLE
        } else {
            val noAppointmentsText = view.findViewById<TextView>(R.id.no_appointments_text)
            noAppointmentsText.visibility = View.GONE
        }

        return view
    }

    // Custom adapter to populate the list
    private inner class AppointmentAdapter(private val appointments: List<Appointment>) :
        ArrayAdapter<Appointment>(requireContext(), R.layout.appointment_item, appointments) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.appointment_item, parent, false)

            val appointment = appointments[position]

            // Set the appointment details
            val appointmentDetailsText = view.findViewById<TextView>(R.id.appointment_details)
            appointmentDetailsText.text = "Date: ${appointment.date}, Time: ${appointment.time}, Type: ${appointment.appointmentType}"

            // Set up the "See Clinic Details" button
            val clinicDetailsButton = view.findViewById<Button>(R.id.see_clinic_details_button)
            clinicDetailsButton.setOnClickListener {
                // Open the clinic's website (or location on map) using implicit intent
                val clinicWebsite = appointment.clinicWebsite
                if (clinicWebsite != null && clinicWebsite.isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(clinicWebsite))
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "Clinic website is unavailable", Toast.LENGTH_SHORT).show()
                }
            }

            return view
        }
    }
}
