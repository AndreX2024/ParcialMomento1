package com.example.parcialmomento1.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.parcialmomento1.R

class MisDatosFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var textViewUsername: TextView
    private lateinit var textViewUserLastname: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var textViewProgram: TextView
    private lateinit var textViewSemester: TextView
    private lateinit var buttonPlanner: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mis_datos, container, false)

        textViewUsername = view.findViewById(R.id.tv_username_profile)
        textViewUserLastname = view.findViewById(R.id.tv_userlastname_profile)
        textViewEmail = view.findViewById(R.id.tv_email_profile)
        textViewProgram = view.findViewById(R.id.tv_program_profile)
        textViewSemester = view.findViewById(R.id.tv_semester_profile)
        buttonPlanner = view.findViewById(R.id.bt_planner)

        sharedPreferences = requireContext().getSharedPreferences("UserData", MODE_PRIVATE)

        cargarDatos()

//        buttonPlanner.setOnClickListener {
//            val intent = Intent(requireContext(), PlannerActivity::class.java)
//            startActivity(intent)
//        }

        return view
    }

    private fun cargarDatos() {
        val nombre = sharedPreferences.getString("Nombres", "No disponible")
        val apellido = sharedPreferences.getString("Apellidos", "No disponible")
        val email = sharedPreferences.getString("Correo Eléctronico", "No disponible")
        val programa = sharedPreferences.getString("Programa", "No disponible")
        val semestre = sharedPreferences.getString("Semestre", "No disponible")

        textViewUsername.text = nombre
        textViewUserLastname.text = apellido
        textViewEmail.text = email
        textViewProgram.text = programa
        textViewSemester.text = semestre
    }
}