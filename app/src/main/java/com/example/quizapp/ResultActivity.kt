package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityQuastionsBinding
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding
    private var correct_questions = 0
    private var total_questions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        total_questions = intent.getIntExtra(Constants.total_questions,0)
        correct_questions = intent.getIntExtra(Constants.correct_answer,0)
        setResult()
        restartQuiz()

    }
    private fun setResult(){
        binding.tvName.text = intent.getStringExtra(Constants.user_name)
        binding.tvScore.text = "Your Score is $correct_questions out of $total_questions"
    }
    private fun restartQuiz(){
        binding.btnRestart.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}