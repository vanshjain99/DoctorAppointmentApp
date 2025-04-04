package com.example.doctorappointmentapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(private val context: Context, private var doctorList: List<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val doctorImage: ImageView = itemView.findViewById(R.id.doctorImage)
        val doctorName: TextView = itemView.findViewById(R.id.doctorName)
        val doctorSpecialization: TextView = itemView.findViewById(R.id.doctorSpecialization)
        val doctorRating: RatingBar = itemView.findViewById(R.id.doctorRating)
        val seeMoreButton: Button = itemView.findViewById(R.id.seeMoreButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctorList[position]

        holder.doctorImage.setImageResource(doctor.image)
        holder.doctorName.text = doctor.name
        holder.doctorSpecialization.text = doctor.specialization
        holder.doctorRating.rating = doctor.rating

        holder.seeMoreButton.setOnClickListener {
            val intent = Intent(context, DoctorProfileActivity::class.java).apply {
                putExtra("doctor_image", doctor.image)
                putExtra("doctor_name", doctor.name)
                putExtra("doctor_specialization", doctor.specialization)
                putExtra("doctor_rating", doctor.rating)
                putExtra("doctor_certifications", doctor.certifications)
                putExtra("doctor_competencies", doctor.competencies)
                putExtra("doctor_languages", doctor.languages)
                putExtra("clinic_name", doctor.clinicName)
                putExtra("clinic_address", doctor.clinicAddress)
                putExtra("clinic_latitude", doctor.clinicLatitude)
                putExtra("clinic_longitude", doctor.clinicLongitude)
            }
            context.startActivity(intent)
        }
    }

    fun updateList(newList: List<Doctor>) {
        doctorList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = doctorList.size
}
