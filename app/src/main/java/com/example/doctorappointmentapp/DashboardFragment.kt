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
import android.view.*

class DashboardFragment : Fragment() {

    private lateinit var dbHelper: AppointmentDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        dbHelper = AppointmentDatabaseHelper(requireContext())

        val listView: ListView = view.findViewById(R.id.appointment_list)
        val noAppointmentsText = view.findViewById<TextView>(R.id.no_appointments_text)
        val deleteAllButton = view.findViewById<Button>(R.id.delete_all_button)

        fun refreshAppointments() {
            val appointments = dbHelper.getAllAppointments()
            if (appointments.isEmpty()) {
                noAppointmentsText.visibility = View.VISIBLE
                listView.visibility = View.GONE
            } else {
                noAppointmentsText.visibility = View.GONE
                listView.visibility = View.VISIBLE
                val adapter = AppointmentAdapter(appointments)
                listView.adapter = adapter
            }
        }

        refreshAppointments()

        deleteAllButton.setOnClickListener {
            dbHelper.clearAllAppointments()
            Toast.makeText(requireContext(), "All appointments deleted", Toast.LENGTH_SHORT).show()
            refreshAppointments()
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
