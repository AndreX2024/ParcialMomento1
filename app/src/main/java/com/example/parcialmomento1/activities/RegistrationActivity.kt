package com.example.parcialmomento1.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parcialmomento1.R

class RegistrationActivity : AppCompatActivity() {

    private lateinit var editText_username : EditText
    private lateinit var editText_userlastname : EditText
    private lateinit var editText_email : EditText
    private lateinit var editText_program : EditText
    private lateinit var editText_semester : EditText
    private lateinit var editText_password : EditText
    private lateinit var editText_confirmPassword : EditText
    private lateinit var checkBox_terms: CheckBox
    private lateinit var button_Registration : Button

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var textView_signUp : TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        Log.d("RegistrationActivity", "onCreate: Inicializando el Activity de Registro")

        editText_username = findViewById(R.id.et_username_registration)
        editText_userlastname = findViewById(R.id.et_userlastname_registration)
        editText_email = findViewById(R.id.et_email_registration)
        editText_program = findViewById(R.id.et_program_registration)
        editText_semester = findViewById(R.id.et_semester_registration)
        editText_password = findViewById(R.id.et_password_registration)
        editText_confirmPassword = findViewById(R.id.et_confirmPassword_registration)
        checkBox_terms = findViewById(R.id.cb_registration)
        textView_signUp = findViewById(R.id.tv_signUp)
        button_Registration = findViewById(R.id.bt_login_registration)


        // Archivo de almacenamiento local
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        button_Registration.setOnClickListener {
            // Validar Campos
            if (validarCampos()){
                // Guardar datos
                guardarDatos()

                // Redireccionar a LoginActivity
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        textView_signUp.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validarCampos(): Boolean {
        val nombres = editText_username.text.toString().trim()
        val apellidos = editText_userlastname.text.toString().trim()
        val email = editText_email.text.toString().trim()
        val program = editText_program.text.toString().trim()
        val semester = editText_semester.text.toString().trim()
        val password = editText_password.text.toString().trim()
        val confirmPassword = editText_confirmPassword.text.toString().trim()
        val isChecked = checkBox_terms.isChecked

        val passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}\$".toRegex()

        if (nombres.isEmpty()) {
            Toast.makeText(this, "El campo nombres es requerido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (apellidos.isEmpty()) {
            Toast.makeText(this, "El campo apellidos es requerido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "El campo correo eléctronico es requerido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (program.isEmpty()) {
            Toast.makeText(this, "El campo programa es requerido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (semester.isEmpty()) {
            Toast.makeText(this, "El campo semestre es requerido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "El campo contraseña es requerido", Toast.LENGTH_SHORT).show()
            return false
        } else if (!password.matches(passwordPattern)) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres, una mayúscula, una minúscula y un número", Toast.LENGTH_LONG).show()
            return false
        }

        if (confirmPassword.isEmpty()) {
            Toast.makeText(this, "Debe confirmar su contraseña", Toast.LENGTH_SHORT).show()
            return false
        } else if (password != confirmPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!isChecked) {
            Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }


    private fun guardarDatos() {
        val editor = sharedPreferences.edit()
        editor.putString("Nombres", editText_username.text.toString().trim())
        editor.putString("Apellidos", editText_userlastname.text.toString().trim())
        editor.putString("Correo Eléctronico", editText_email.text.toString().trim())
        editor.putString("Programa", editText_program.text.toString().trim())
        editor.putString("Semestre", editText_semester.text.toString().trim())
        editor.putString("Contraseña", editText_confirmPassword.text.toString().trim())
        editor.apply()

        Toast.makeText(this, "Registro completado exitosamente!", Toast.LENGTH_SHORT).show()

    }

}