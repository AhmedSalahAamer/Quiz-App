package com.example.quizapp

object Constants {

    const val user_name:String = "User Name"
    const val total_questions : String = "Total Questions"
    const val correct_answer : String = "Correct Answers"
    fun getQuestions():ArrayList<Questions>{
        var questionList = ArrayList<Questions>()
        val Q1 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.egyptflag,
            "Egypt","Morcoo","Tunisia","Saudi Arabia",
            1
        )
        questionList.add(Q1)

        val Q2 = Questions(
            2,
            "What country does this flag belong to?",
            R.drawable.algeria,
            "Egypt","Morcoo","Tunisia","Algeria",
            4
        )
        questionList.add(Q2)

        val Q3 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.morcooflag,
            "China","Morcoo","Tunisia","Saudi Arabia",
            2
        )
        questionList.add(Q3)

        val Q4 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.saudia_arabia,
            "Cameroon","Chad","Russia","Saudi Arabia",
            4
        )
        questionList.add(Q4)
        val Q5 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.anguilla,
            "Anguilla","Comoros","Austallia","Colombia",
            1
        )
        questionList.add(Q5)
        val Q6 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.austallia,
            "Anguilla","Angola","Austallia","Argentina",
            3
        )
        questionList.add(Q6)
        val Q7 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.argentina,
            "Anguilla","Angola","Austallia","Argentina",
            4
        )
        questionList.add(Q7)

        val Q8 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.tunisiaflag,
            "Sudan","Syria","Tunisia","Thailand",
            3
        )
        questionList.add(Q8)

        val Q9 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.cabo,
            "Cabo","Cameroon","Chad","Colombia",
            1
        )
        questionList.add(Q9)

        val Q10 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.israel,
            "Israel","India","Italy","Bnt Elws5a",
            4
        )
        questionList.add(Q10)


        return questionList
    }
}