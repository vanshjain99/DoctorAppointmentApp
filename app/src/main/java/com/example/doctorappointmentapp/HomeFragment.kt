package com.example.doctorappointmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointmentapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var doctorAdapter: DoctorAdapter
    private val doctorList = mutableListOf<Doctor>() // Ensure doctorList is defined

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Initialize doctors list
        doctorList.addAll(
            listOf(
                Doctor(
                    name = "Dr. John Doe",
                    specialization = "Cardiologist",
                    rating = 4.5f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MD",
                    competencies = "Heart Surgery, ECG Analysis",
                    languages = "English, Hindi",
                    clinicName = "Heart Care Clinic",
                    clinicAddress = "123 Heart Ave, City",
                    clinicLatitude = 28.7041,
                    clinicLongitude = 77.1025
                ),
                Doctor(
                    name = "Dr. Jane Smith",
                    specialization = "Dermatologist",
                    rating = 4.7f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, DDVL",
                    competencies = "Skin Treatments, Laser Therapy",
                    languages = "English, French",
                    clinicName = "Skin Solutions",
                    clinicAddress = "456 Skin St, City",
                    clinicLatitude = 28.5355,
                    clinicLongitude = 77.3910
                ),
                Doctor(
                    name = "Dr. Michael Brown",
                    specialization = "Orthopedic Surgeon",
                    rating = 4.6f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MS (Orthopedics)",
                    competencies = "Joint Replacement, Bone Fracture Treatment",
                    languages = "English, Spanish",
                    clinicName = "Bone & Joint Center",
                    clinicAddress = "789 Bone Rd, City",
                    clinicLatitude = 28.6228,
                    clinicLongitude = 77.0369
                ),
                Doctor(
                    name = "Dr. Emily White",
                    specialization = "Pediatrician",
                    rating = 4.8f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, DCH",
                    competencies = "Child Vaccination, Pediatric Care",
                    languages = "English, Tamil",
                    clinicName = "Kids Care Clinic",
                    clinicAddress = "321 Kids St, City",
                    clinicLatitude = 28.7041,
                    clinicLongitude = 77.1025
                ),
                Doctor(
                    name = "Dr. William Harris",
                    specialization = "Gynecologist",
                    rating = 4.4f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MD (Gynecology)",
                    competencies = "Pregnancy Care, Menstrual Disorders",
                    languages = "English, Bengali",
                    clinicName = "Women’s Health Clinic",
                    clinicAddress = "654 Women’s Rd, City",
                    clinicLatitude = 28.6561,
                    clinicLongitude = 77.1153
                ),
                Doctor(
                    name = "Dr. Ava Johnson",
                    specialization = "Neurologist",
                    rating = 4.9f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MD (Neurology)",
                    competencies = "Epilepsy Treatment, Stroke Care",
                    languages = "English, Kannada",
                    clinicName = "Brain & Spine Clinic",
                    clinicAddress = "102 Neuro Blvd, City",
                    clinicLatitude = 28.6127,
                    clinicLongitude = 77.2295
                ),
                Doctor(
                    name = "Dr. David Lee",
                    specialization = "Psychiatrist",
                    rating = 4.3f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MD (Psychiatry)",
                    competencies = "Mental Health, Depression Treatment",
                    languages = "English, Hindi",
                    clinicName = "Mind Care Clinic",
                    clinicAddress = "987 Mind Ave, City",
                    clinicLatitude = 28.5355,
                    clinicLongitude = 77.3589
                ),
                Doctor(
                    name = "Dr. Olivia Moore",
                    specialization = "General Physician",
                    rating = 4.6f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MD (General Medicine)",
                    competencies = "Fever, Cold, Chronic Disease Management",
                    languages = "English, Marathi",
                    clinicName = "Health First Clinic",
                    clinicAddress = "111 Health Rd, City",
                    clinicLatitude = 28.6342,
                    clinicLongitude = 77.0912
                ),
                Doctor(
                    name = "Dr. James Clark",
                    specialization = "Ophthalmologist",
                    rating = 4.7f,
                    image = R.drawable.sample_doctor,
                    certifications = "MBBS, MS (Ophthalmology)",
                    competencies = "Eye Surgery, Cataract Treatment",
                    languages = "English, Telugu",
                    clinicName = "Vision Care Clinic",
                    clinicAddress = "123 Vision Blvd, City",
                    clinicLatitude = 28.7352,
                    clinicLongitude = 77.1173
                ),
                Doctor(
                    name = "Dr. Sophia Walker",
                    specialization = "Dentist",
                    rating = 4.8f,
                    image = R.drawable.sample_doctor,
                    certifications = "BDS, MDS",
                    competencies = "Root Canal Treatment, Teeth Whitening",
                    languages = "English, Punjabi",
                    clinicName = "Smile Dental Clinic",
                    clinicAddress = "852 Smile St, City",
                    clinicLatitude = 28.6473,
                    clinicLongitude = 77.1168
                )
            )
        )


        // Set up RecyclerView
        doctorAdapter = DoctorAdapter(requireContext(), doctorList)
        binding.recyclerViewDoctors.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDoctors.adapter = doctorAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
