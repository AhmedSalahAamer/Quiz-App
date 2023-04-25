package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapp.databinding.ActivityQuastionsBinding

class QuestionsActivity : AppCompatActivity() {
    lateinit var binding:ActivityQuastionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuastionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questionList = Constants.getQuestions()
        Log.i("QuestionList size is","${questionList.size}")

        var currentPosition = 0
        val question : Questions = questionList[currentPosition]
        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "$currentPosition/${binding.progressBar.max}"


    }
}