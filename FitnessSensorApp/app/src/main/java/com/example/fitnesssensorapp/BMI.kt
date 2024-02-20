package com.example.fitnesssensorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val height = findViewById<EditText>(R.id.eTHeight)
        val weight = findViewById<EditText>(R.id.eTWeight)
        val btnCal = findViewById<Button>(R.id.btnBMI)
        val res = findViewById<TextView>(R.id.tVResult)

        btnCal.setOnClickListener {
            val h = (height.text.toString().toFloat())/100
            val w = (weight.text.toString().toFloat())

            val r= w/(h*h)
            res.text = "Your Bmi is : $r"
        }

    }
}