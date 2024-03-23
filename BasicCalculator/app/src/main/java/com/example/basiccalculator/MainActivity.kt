package com.example.basiccalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var editNo1: EditText
    private lateinit var editNo2: EditText
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editNo1 = findViewById(R.id.editNo1);
        editNo2 = findViewById(R.id.editNo2);
        textResult = findViewById(R.id.textResult);
    }

    fun onAddClick(view: View?) {
        calculate('+')
    }

    fun onSubtractClick(view: View?) {
        calculate('-')
    }

    fun onMultiplyClick(view: View?) {
        calculate('*')
    }

    fun onDivideClick(view: View?) {
        calculate('/')
    }

    fun onModulusClick(view: View?) {
        calculate('%')
    }

    fun onCalculateClick(view: View?) {
        calculate(' ')
    }

    private fun calculate(operator: Char) {
        val num1: Double = editNo1?.getText().toString().toDouble()
        val num2: Double = editNo2?.getText().toString().toDouble()
        var result = 0.0
        when (operator) {
            '+' -> result = num1 + num2
            '-' -> result = num1 - num2
            '*' -> result = num1 * num2
            '/' -> if (num2 != 0.0) result =
                num1 / num2 else textResult?.setText("Cannot divide by zero")

            '%' -> if (num2 != 0.0) result =
                num1 % num2 else textResult?.setText("Cannot modulo by zero")

            else -> textResult?.setText("Invalid operator")
        }
        textResult?.setText("Result: $result")
    }
}