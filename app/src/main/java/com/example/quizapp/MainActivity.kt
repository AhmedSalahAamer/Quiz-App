package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btStart = findViewById<Button>(R.id.btn_start)
        var etName = findViewById<EditText>(R.id.et_name)
        btStart.setOnClickListener {
            if (etName.text.isEmpty())
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            else {
                val intent = Intent(this,QuestionsActivity::class.java)
                startActivity(intent)
            }
        }

    }
}