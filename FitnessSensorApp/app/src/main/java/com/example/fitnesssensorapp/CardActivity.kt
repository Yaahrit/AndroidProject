package com.example.fitnesssensorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        val bmi = findViewById<ImageView>(R.id.imgBMI)
        val sensor = findViewById<ImageView>(R.id.imgPedoMeter)

        bmi.setOnClickListener {
            val i = Intent(this,BMI::class.java)
            startActivity(i)
        }
        sensor.setOnClickListener {
            val i = Intent(this,Pedometer::class.java)
            startActivity(i)
        }
    }
}