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

        val Q2 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_bg,
            "Egypt","Marcoo","Tonis","Saudi Arabia",
            3
        )
        questionList.add(Q2)

        val Q3 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_bg,
            "Egypt","Marcoo","Tonis","Saudi Arabia",
            2
        )
        questionList.add(Q3)

        val Q4 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_bg,
            "Egypt","Marcoo","Tonis","Saudi Arabia",
            4
        )
        questionList.add(Q4)
        return questionList
    }
}