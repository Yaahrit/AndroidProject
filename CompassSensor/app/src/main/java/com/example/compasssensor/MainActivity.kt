package com.example.compasssensor

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(),SensorEventListener {

    private var sensor:Sensor?=null
    private var sensorManager:SensorManager?=null
    private lateinit var compassImage:ImageView
    private lateinit var rotationTv : TextView

    private var currentDegree = 0f

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor=sensorManager!!.getDefaultSensor(Sensor.TYPE_ORIENTATION)

        compassImage = findViewById(R.id.imageView)
        rotationTv = findViewById(R.id.textView)
    }

    @SuppressLint("SetTextI18n")
    override fun onSensorChanged(event: SensorEvent?) {
        val degree = Math.round(event!!.values[0])
        Log.d(TAG, "onSensorChanged: $degree")
        rotationTv.text = degree.toString() + "Degree's "

        val rotAnimation = RotateAnimation(currentDegree,(-degree).toFloat(),Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)

        rotAnimation.duration = 210
        rotAnimation.fillAfter = true
        compassImage.startAnimation(rotAnimation)
        currentDegree=(-degree).toFloat()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}