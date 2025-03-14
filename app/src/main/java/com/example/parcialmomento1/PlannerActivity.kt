package com.example.parcialmomento1

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PlannerActivity : AppCompatActivity() {

    private lateinit var editTextWeight: EditText
    private lateinit var checkBoxPhysicalCondition: CheckBox
    private lateinit var checkBoxPhysicalCondition2: CheckBox
    private lateinit var checkBoxPhysicalCondition3: CheckBox

    private lateinit var checkBoxObjetive: CheckBox
    private lateinit var checkBoxObjetive2: CheckBox
    private lateinit var checkBoxObjetive3: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}