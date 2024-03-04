package com.example.textscanningapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class OpeningScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, OnBoardingScreen::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}
