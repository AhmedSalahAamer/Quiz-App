package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuastionsBinding

class QuestionsActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var binding:ActivityQuastionsBinding
    private var mCurrentPostion:Int=1
    private var mQuestionList:ArrayList<Questions>?=null
    private var mSelectedOptionPostion:Int=0

    private var mUserName: String? =null
    private var mCorrectAnswer : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuastionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserName = intent.getStringExtra(Constants.user_name)

        binding.tvOption1.setOnClickListener(this)
        binding.tvOption2.setOnClickListener(this)
        binding.tvOption3.setOnClickListener(this)
        binding.tvOption4.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()


    }

    private fun setQuestion() {

        defualteOptionView()
        val question: Questions = mQuestionList!![mCurrentPostion-1]
        binding.progressBar.max=mQuestionList!!.size
        binding.tvProgress.text = "${mCurrentPostion}/${binding.progressBar.max}"
        binding.imageView.setImageResource(question.image)
        binding.tvTitle.text = question.question
        binding.tvOption1.text = question.optionOne
        binding.tvOption2.text = question.optionTwo
        binding.tvOption3.text = question.optionThree
        binding.tvOption4.text = question.optionFour

        if (mCurrentPostion == mQuestionList!!.size)
            binding.btnSubmit.text="Finish"
        else
            binding.btnSubmit.text="Submit"
    }

    private fun defualteOptionView(){
        val options = ArrayList<TextView>()
        binding.tvOption1.let {
            options.add(0,it)
        }
        binding.tvOption2.let {
            options.add(1,it)
        }
        binding.tvOption3.let {
            options.add(2,it)
        }
        binding.tvOption4.let {
            options.add(3,it)
        }

        for(option in options)
        {
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.defult_option
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defualteOptionView()
        mSelectedOptionPostion = selectedOptionNum
        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option
        )
    }




    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1 -> {
                binding.tvOption1.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option2 -> {
                binding.tvOption2.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option3 -> {
                binding.tvOption3.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option4 -> {
                binding.tvOption4.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPostion == 0){
                    mCurrentPostion++
                    when{
                        mCurrentPostion <= mQuestionList!!.size -> {
                            setQuestion()
                        }else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.user_name,mUserName)
                            intent.putExtra(Constants.correct_answer,mCorrectAnswer)
                            intent.putExtra(Constants.total_questions,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {

                    val question = mQuestionList?.get(mCurrentPostion-1)

                    if(question!!.correctAnswer != mSelectedOptionPostion){
                        answerView(mSelectedOptionPostion,R.drawable.wrong_option)
                    }
                    else{
                        mCorrectAnswer++
                    }

                    answerView(question.correctAnswer,R.drawable.correct_option)
                    if (mCurrentPostion == mQuestionList!!.size){
                        binding.btnSubmit.text = "Finish"
                    }else{
                        binding.btnSubmit.text = "go to the next question"
                    }

                    mSelectedOptionPostion = 0
                }


            }
        }

    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1 ->{
                binding.tvOption1.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                binding.tvOption2.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                binding.tvOption3.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                binding.tvOption4.background = ContextCompat.getDrawable(this,drawableView)
            }
        }

    }

}