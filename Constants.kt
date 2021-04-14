package com.example.Quiz

object Constants {
    fun getQuestions(): ArrayList<Questions>{
        val QuestionList = ArrayArrayList<Questions>()

        val question1 = Question(
                1,
                "De combien de joueurs est composée une équipe de volley ?",
                "deux",
                "six",
                "14",
                2

        )
        questionList.add(question1)

        val question2 = Question(
            2,
            "Quel est le joeur destiné pour réception de ball  ?",
            "Libero",
            "passeur",
            "Auxiliaire",
            1
        )

        questionList.add(question2)

        val question3 = Question(
                3,
                "combien y a de type de rotations au volley",
                "trois",
                "dix",
                "cinq",
                3
        )

        questionList.add(question3)

        val question4 = Question(
                4,
                "comment s'appelle l'entraineur de l'équipe national de france du volley ?",
                "Bernardinho",
                "Laurent Tillie",
                "Arthur",
                2
        )

        questionList.add(question4)

        val question5 = Question(
                5,
                "de combien est comosé l'ensemble d'arbitrage ?",
                "six arbitres",
                "deux arbitres",
                "trois arbitres",
                3
        )
        questionList.add(question5)

        return questionList
    }
}