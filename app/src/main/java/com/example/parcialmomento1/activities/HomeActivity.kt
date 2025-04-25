package com.example.parcialmomento1.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.parcialmomento1.R

class HomeActivity : AppCompatActivity() {

    private lateinit var button_Start : Button
    private lateinit var tv_registrationHome : TextView

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button_Start = findViewById(R.id.bt_start)

        button_Start.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        tv_registrationHome = findViewById(R.id.tv_login_home)

        tv_registrationHome.setOnClickListener {
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Datos ya registrados para iniciar sesión
        sharedPreferences.edit() {
            putString("Nombres", "Carlos Andrés")
            putString("Apellidos", "Castaño Gaitán")
            putString("Correo Eléctronico", "cacastano@ucompensar.edu.co")
            putString("Programa", "Ingenieria de Software")
            putString("Semestre", "7")
            putString("Contraseña", "Pruebas123")
        }
    }
}