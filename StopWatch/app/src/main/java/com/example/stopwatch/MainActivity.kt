package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isRun = false
    private var timerSecond = 0

    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable{
        override fun run() {
            timerSecond++
            val hours = timerSecond / 3600
            val minutes = (timerSecond % 3600) / 60
            val seconds = timerSecond % 60

            val time = String.format("%02d:%02d:%02d",hours,minutes,seconds)
            binding.timerText.text = time

            handler.postDelayed(this,1000)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startbtn.setOnClickListener{
            startTimer()
        }
        binding.stopbtn.setOnClickListener{
            stopTimer()
        }
        binding.restbtn.setOnClickListener {
            resetTimer()
        }
    }
    private fun startTimer(){
        if(!isRun){
            handler.postDelayed(runnable,1000)
            isRun = true

            binding.startbtn.isEnabled = false
            binding.stopbtn.isEnabled = true
            binding.restbtn.isEnabled = true
        }
    }

    private fun stopTimer()
    {
        if(!isRun){
            handler.removeCallbacks(runnable)
            isRun = false

            binding.startbtn.isEnabled = true
            binding.startbtn.text = "Resume"
            binding.stopbtn.isEnabled = false
            binding.restbtn.isEnabled = true
        }
    }

    private fun resetTimer()
    {
        stopTimer()
        timerSecond = 0
        binding.timerText.text = "00:00:00"
        binding.startbtn.isEnabled = true
        binding.restbtn.isEnabled = false
        binding.startbtn.text = "Start"
    }
}