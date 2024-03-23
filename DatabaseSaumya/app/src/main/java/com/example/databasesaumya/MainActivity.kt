package com.example.databasesaumya

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSave: Button

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.eTName)
        editTextPassword = findViewById(R.id.eTPassword)
        buttonSave = findViewById(R.id.btnSave)

        buttonSave.setOnClickListener {
            val sharedPref = getSharedPreferences("Login Data", MODE_PRIVATE)
            val editor = sharedPref.edit()
            val n = editTextName.text.toString()
            val x = editTextPassword.text.toString()
            editor.putString("Name", n)
            editor.putString("Password", x)
            editor.apply()

            val i = Intent(this, HomeScreen::class.java)
            startActivity(i)
        }
    }
}