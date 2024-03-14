package com.example.firstaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eprompt = findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit = findViewById<Button>(R.id.btn)
        val tvRes = findViewById<TextView>(R.id.tVResult)

        btnSubmit.setOnClickListener {
            val prompt = eprompt.text.toString()
            val generativeModel = GenerativeModel(
                // For text-only input, use the gemini-pro model
                modelName = "gemini-pro",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyCnKVkDT0BHBSLC146LPEasuvOGjJTXohQ"
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)

                // Format the result with bullet points and describe the user-entered prompt
                val resultText = buildString {
                    append("User Prompt: $prompt\n\n")
                    append("Generated Content:\n")
                    for (bulletPoint in response.text!!.split("\n")) {
                        append(" • $bulletPoint\n")
                    }
                }

                tvRes.text = resultText
            }
        }
    }
}
