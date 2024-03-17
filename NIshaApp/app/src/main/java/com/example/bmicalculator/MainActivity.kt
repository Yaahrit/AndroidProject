package com.example.bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calBtn.setOnClickListener{
            calculatorBMI()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculatorBMI()
    {
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if(weight!=null && height!=null){
            val bmi = weight/(height/100).pow(2)
            val bmiResult = String.format("%.2f",bmi)

            val bmiCategory = when{
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal weight"
                bmi < 30 -> "Overweight"
                else ->"Obese"
            }
            binding.restext.text = "BMI: $bmiResult\nCategory : $bmiCategory"
        }else{
            binding.restext.text = "Invalid Input"
        }
    }
}