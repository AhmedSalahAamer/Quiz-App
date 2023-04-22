package com.example.quizapp

object Constants {
    fun getQuestions():ArrayList<Questions>{
        var questionList = ArrayList<Questions>()
        val Q1 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_bg,
            "Egypt","Marcoo","Tonis","Saudi Arabia",
            1
        )
        questionList.add(Q1)
        return questionList
    }
}