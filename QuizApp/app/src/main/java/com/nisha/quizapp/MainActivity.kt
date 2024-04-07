package com.nisha.quizapp

import android.graphics.Color
import android.icu.text.AlphabeticIndex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nisha.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val questions = arrayOf(
        "What is the built-in database in android studion?",
        "What is the primary programming language used in Android development?\n",
        "Which layout manager is commonly used for arranging UI elements in Android applications?\n",
        "What is the purpose of the AndroidManifest.xml file in an Android project?\n",
        "Which component is responsible for handling background tasks in Android applications?\n",
        "What is the significance of the \"R.java\" file in Android development?\n",
        "How do you declare permissions for accessing device features in an AndroidManifest.xml file?\n",
        "What is the difference between \"match_parent\" and \"wrap_content\" in Android layout XML attributes?\n",
        "How do you handle user interactions in Android applications?\n",
        "What is the role of the \"Activity\" class in the Android application lifecycle?\n",
        "How do you handle different screen sizes and densities in Android development?"
    )
    private val options = arrayOf(
        arrayOf("MYSQL", "SQLITE", "FIREBASE"),  // Options for Question 1
        arrayOf("Java", "Kotlin", "C++"),         // Options for Question 2 (add options as needed)
        arrayOf("LinearLayout", "RelativeLayout", "ConstraintLayout"),  // Options for Question 3
        arrayOf(
            "It defines the structure and metadata of the application",
            "It contains the user interface components of the application",
            "It declares the permissions required by the application"
        ),  // Options for Question 4
        arrayOf("AsyncTask", "Service", "BroadcastReceiver"),  // Options for Question 5
        arrayOf(
            "It contains references to all the resources used in the project",
            "It's an automatically generated file that holds references to the resources in the 'res' directory",
            "It's a Java file where you define your application's activities and layout XML files"
        ),  // Options for Question 6
        arrayOf(
            "Using the <permission> tag",
            "By declaring them within the <application> tag",
            "By requesting them at runtime"
        ),  // Options for Question 7
        arrayOf(
            "match_parent makes the view expand to fill the available space in its parent, while wrap_content makes the view only be as big as its content requires",
            "match_parent and wrap_content are the same",
            "match_parent is used for height and wrap_content is used for width"
        ),  // Options for Question 8
        arrayOf(
            "By implementing event listeners",
            "By using the onClick attribute in XML layout files",
            "By handling touch events manually"
        ),  // Options for Question 9
        arrayOf(
            "It represents a single screen with a user interface",
            "It manages the application's resources and provides a user interface",
            "It's responsible for managing the application's lifecycle and handling user interactions"
        ),  // Options for Question 10
        arrayOf(
            "By providing different layout files for different screen sizes and densities in the 'res' directory",
            "By using the 'wrap_content' attribute in XML layout files",
            "By adjusting the text size programmatically based on screen size"
        )  // Options for Question 11
    )

    private val correctAns = arrayOf(1, 1, 2, 0, 1, 1, 0, 0, 0, 2, 0)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayQuestion()

        binding.option1Button.setOnClickListener {
            checkAnswer(0)
        }
        binding.option2Button.setOnClickListener {
            checkAnswer(1)
        }
        binding.option3Button.setOnClickListener {
            checkAnswer(2)
        }
        binding.restartButton.setOnClickListener {
            restartQuiz()
        }
    }

    private fun correctButtonColors(buttonIndex: Int) {
        when (buttonIndex) {
            0 -> binding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> binding.option2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.option3Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColor(buttonIndex: Int) {
        when (buttonIndex) {
            0 -> binding.option1Button.setBackgroundColor(Color.RED)
            1 -> binding.option2Button.setBackgroundColor(Color.RED)
            2 -> binding.option3Button.setBackgroundColor(Color.RED)
        }
    }

    private fun resetButtonColor() {
        binding.option1Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.option2Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.option3Button.setBackgroundColor(Color.rgb(50, 59, 96))
    }

    private fun showResult() {
        Toast.makeText(this, "Your score : $score out of ${questions.size}", Toast.LENGTH_LONG)
            .show()
        binding.restartButton.isEnabled = true
    }

    private fun displayQuestion() {
        binding.QuestionText.text = questions[currentQuestionIndex]
        binding.option1Button.text = options[currentQuestionIndex][0]
        binding.option2Button.text = options[currentQuestionIndex][1]
        binding.option3Button.text = options[currentQuestionIndex][2]
        resetButtonColor()
    }

    private fun checkAnswer(selectedAnswerIndex: Int) {
        val correctAnswerIndex = correctAns[currentQuestionIndex]

        if (selectedAnswerIndex == correctAnswerIndex) {
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            wrongButtonColor(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            binding.QuestionText.postDelayed({ displayQuestion() }, 1000)
        } else {
            showResult()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex=0
        score=0
        displayQuestion()
        binding.restartButton.isEnabled=false
    }

}