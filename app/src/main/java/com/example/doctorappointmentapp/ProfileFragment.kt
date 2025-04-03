package com.example.doctorappointmentapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Find views
        val profileImage = view.findViewById<ImageView>(R.id.profile_image)
        val profileName = view.findViewById<TextView>(R.id.profile_name)
        val profileEmail = view.findViewById<TextView>(R.id.profile_email)
        val btnEditProfile = view.findViewById<Button>(R.id.btn_edit_profile)
        val btnLogout = view.findViewById<Button>(R.id.btn_logout)

        // Set dummy user data (Replace with actual user data)
        profileName.text = "Vansh Jain"
        profileEmail.text = "i25031409@student.newinti.edu.my"

        // Edit Profile Button Click
        btnEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        }

        // Logout Button Click
        btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Logged Out", Toast.LENGTH_SHORT).show()
            // Redirect to login (if required)
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }
}
