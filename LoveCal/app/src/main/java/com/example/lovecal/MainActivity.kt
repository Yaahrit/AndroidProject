package com.example.lovecal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var yourNameEditText: EditText
    private lateinit var partnerNameEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        yourNameEditText = findViewById(R.id.yourNameEditText)
        partnerNameEditText = findViewById(R.id.partnerNameEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener { calculateLove() }
    }
    private fun calculateLove() {
        val yourName = yourNameEditText.text.toString().trim()
        val partnerName = partnerNameEditText.text.toString().trim()

        if (yourName.isNotEmpty() && partnerName.isNotEmpty()) {
            val lovePercentage = generateLovePercentage()
            val resultMessage = "Your love percentage with $partnerName is $lovePercentage%."

            resultTextView.text = resultMessage
        }
    }

    private fun generateLovePercentage(): Int {
        // A simple random calculation for demonstration purposes
        return Random.nextInt(50, 101)
    }
}