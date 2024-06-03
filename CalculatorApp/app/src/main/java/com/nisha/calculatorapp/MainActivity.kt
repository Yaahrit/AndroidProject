package com.nisha.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvView: TextView? = null
    private var btnOne: Button? = null
    private var lastNumber: Boolean = false
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvView = findViewById(R.id.tvView)
        btnOne = findViewById(R.id.btnOne)
        btnOne?.setOnClickListener {
            tvView?.append("1")
        }
    }

    fun onDigit(view: View) {
        tvView?.append((view as Button).text)
        lastNumber = true
        lastDot = false

//        var sentence = "Yash Raj is a coder"
//        if (sentence.contains("Denis")) {
//            tvView?.append("Yash Raj")
//        }
    }

    fun onClear(view: View) {
        tvView?.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNumber && !lastDot) {
            tvView?.append(".")
            lastNumber = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        tvView?.text?.let {

            if (lastNumber && !isOperatorAdded(it.toString())) {
                tvView?.append((view as Button).text)
                lastNumber = false
                lastDot = false
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun onEqual(view: View) {
        if (lastNumber) {
            var tvValue = tvView?.text.toString()
            var prefix = ""

            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    tvView?.text = removeAfterZero((one.toDouble() - two.toDouble()).toString())
                } else if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    tvView?.text = removeAfterZero((one.toDouble() + two.toDouble()).toString())
                } else if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    tvView?.text = removeAfterZero((one.toDouble() / two.toDouble()).toString())
                } else if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    tvView?.text = removeAfterZero((one.toDouble() * two.toDouble()).toString())
                }


            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeAfterZero(res:String):String{
        var value = res
        if(res.contains(".0"))
            value = res.substring(0,res.length-2)
        return value
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}