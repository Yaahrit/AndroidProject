package com.nisha.animationforyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvView = findViewById<TextView>(R.id.textView)
        val fadein = findViewById<Button>(R.id.btn1)
        val fadeout = findViewById<Button>(R.id.btn2)
        val zoomin = findViewById<Button>(R.id.btn3)
        val zoomout = findViewById<Button>(R.id.btn4)
        val rotate = findViewById<Button>(R.id.btn5)
        val bounce = findViewById<Button>(R.id.btn6)

        fadein.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            tvView.startAnimation(animationFadeIn)
        }
        fadeout.setOnClickListener {
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            tvView.startAnimation(animationFadeOut)
        }
        zoomin.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            tvView.startAnimation(animationZoomIn)
        }
        zoomout.setOnClickListener {
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            tvView.startAnimation(animationZoomOut)
        }
        rotate.setOnClickListener {
            val animationrotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            tvView.startAnimation(animationrotate)
        }
        bounce.setOnClickListener {
            val animationbounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            tvView.startAnimation(animationbounce)
        }
    }
}