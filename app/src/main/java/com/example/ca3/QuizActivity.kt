package com.example.ca3

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    private val questions = listOf(
        "What is investing?",
        "What is an IPO?",
        "What is SEBI?"
    )
    private val options = listOf(
        listOf("Saving", "Buying assets", "Trading", "Loaning"),
        listOf("Public offer", "Private offer", "Internal offer", "None"),
        listOf("Stock Exchange", "Bank", "Regulator", "Loan Institution")
    )
    private val answers = listOf(1, 0, 2)
    private var currentQuestionIndex = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadQuestion()
        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            checkAnswer()
        }
    }
    private fun loadQuestion() {
        findViewById<TextView>(R.id.tvQuestion).text = questions[currentQuestionIndex]
        findViewById<RadioButton>(R.id.rbOption1).text = options[currentQuestionIndex][0]
        findViewById<RadioButton>(R.id.rbOption2).text = options[currentQuestionIndex][1]
        findViewById<RadioButton>(R.id.rbOption3).text = options[currentQuestionIndex][2]
        findViewById<RadioButton>(R.id.rbOption4).text = options[currentQuestionIndex][3]
    }

    private fun checkAnswer() {
        val radioGroup = findViewById<RadioGroup>(R.id.rgOptions)
        val selectedOptionId = radioGroup.checkedRadioButtonId
        if (selectedOptionId == -1) {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
            return
        }
        val selectedRadioButton = findViewById<RadioButton>(selectedOptionId)
        val correctAnswerIndex = 1
        if (selectedRadioButton.text == options[currentQuestionIndex][correctAnswerIndex]) {
            score++
        }
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            loadQuestion()
        } else {
            Toast.makeText(this, "Quiz completed! Your score is $score", Toast.LENGTH_LONG).show()
        }
    }
}