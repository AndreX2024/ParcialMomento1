package com.example.parcialmomento1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlannerActivity : AppCompatActivity() {

    private lateinit var editTextWeight: EditText
    private lateinit var checkBoxPhysicalCondition: CheckBox
    private lateinit var checkBoxPhysicalCondition2: CheckBox
    private lateinit var checkBoxPhysicalCondition3: CheckBox

    private lateinit var checkBoxObjetive: CheckBox
    private lateinit var checkBoxObjetive2: CheckBox
    private lateinit var checkBoxObjetive3: CheckBox

    private lateinit var buttonCalculate: Button



    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner)


        Log.d("RegistrationActivity", "onCreate: Inicializando el Activity de Registro")

        editTextWeight = findViewById(R.id.et_weight);
        checkBoxPhysicalCondition = findViewById(R.id.cb_physicalCondition);
        checkBoxPhysicalCondition2 = findViewById(R.id.cb_physicalCondition2);
        checkBoxPhysicalCondition3= findViewById(R.id.cb_physicalCondition3);
        checkBoxObjetive= findViewById(R.id.cb_objetive);
        checkBoxObjetive2= findViewById(R.id.cb_objetive2);
        checkBoxObjetive3= findViewById(R.id.cb_objetive3);
        buttonCalculate= findViewById(R.id.bt_calculate);


        buttonCalculate.setOnClickListener {
            if(validarCampos()) {
                
            }
        }

    }

    private fun validarCampos(): Boolean {
        val peso = editTextWeight.text.toString().trim()
        val isCheckedCondition = checkBoxPhysicalCondition.isChecked
        val isCheckedCondition2 = checkBoxPhysicalCondition2.isChecked
        val isCheckedCondition3 = checkBoxPhysicalCondition3.isChecked
        val isCheckedObjetive = checkBoxObjetive.isChecked
        val isCheckedObjetive2 = checkBoxObjetive2.isChecked
        val isCheckedObjetive3 = checkBoxObjetive3.isChecked

        if (peso.isEmpty()) {
            Toast.makeText(this, "El campo peso es requerido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!isCheckedCondition) {
            Toast.makeText(this, "Debe seleccionar una opción de condición física", Toast.LENGTH_LONG).show()
            return false
        } else if (!isCheckedCondition && !isCheckedCondition2 || !isCheckedCondition && !isCheckedCondition3) {
            Toast.makeText(this, "Debe seleccionar solo una opción de condición física", Toast.LENGTH_LONG).show()
        }

        if (!isCheckedCondition2) {
            Toast.makeText(this, "Debe seleccionar una opción de condición física", Toast.LENGTH_LONG).show()
            return false
        } else if (!isCheckedCondition2 && !isCheckedCondition || !isCheckedCondition2 && !isCheckedCondition3) {
            Toast.makeText(this, "Debe seleccionar solo una opción de condición física", Toast.LENGTH_LONG).show()
            return false
        }

        if (!isCheckedCondition3) {
            Toast.makeText(this, "Debe seleccionar una opción de condición física", Toast.LENGTH_LONG).show()
            return false
        } else if (!isCheckedCondition3 && !isCheckedCondition || !isCheckedCondition3 && !isCheckedCondition2) {
            Toast.makeText(this, "Debe seleccionar solo una opción de condición física", Toast.LENGTH_LONG).show()
            return false
        }

        if (!isCheckedObjetive) {
            Toast.makeText(this, "Debe seleccionar una opción de objetivo", Toast.LENGTH_LONG).show()
            return false
        } else if (!isCheckedObjetive && !isCheckedObjetive2 || !isCheckedObjetive && !isCheckedObjetive3) {
            Toast.makeText(this, "Debe seleccionar solo una opción de objetivo", Toast.LENGTH_LONG).show()
            return false
        }

        if (!isCheckedObjetive2) {
            Toast.makeText(this, "Debe seleccionar una opción de objetivo", Toast.LENGTH_LONG).show()
            return false
        } else if (!isCheckedObjetive2 && !isCheckedObjetive || !isCheckedObjetive2 && !isCheckedObjetive3) {
            Toast.makeText(this, "Debe seleccionar solo una opción de objetivo", Toast.LENGTH_LONG).show()
            return false
        }

        if (!isCheckedObjetive3) {
            Toast.makeText(this, "Debe seleccionar una opción de objetivo", Toast.LENGTH_LONG).show()
            return false
        } else if (!isCheckedObjetive3 && !isCheckedObjetive || !isCheckedObjetive3 && !isCheckedObjetive2) {
            Toast.makeText(this, "Debe seleccionar solo una opción de objetivo", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

}