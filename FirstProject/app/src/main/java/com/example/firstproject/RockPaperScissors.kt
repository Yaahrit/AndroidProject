package com.example.firstproject

fun main(){
    var computerchoice=""
    var playerChoice=""
    println("Rock,Paper or Scissors? Enter your choice! ")
    playerChoice = readln()

    when((1..3).random()) {
        1 -> {
            computerchoice = "Rock"
        }

        2 -> {
            computerchoice = "Paper"
        }

        3 -> {
            computerchoice = "Scissors"
        }
    }
    println(computerchoice)

    val winner = when{
        playerChoice == computerchoice->"Tie"
        playerChoice == "Rock" && computerchoice == "Scissors"->"Player"
        playerChoice == "Paper" && computerchoice == "Rock"->"Player"
        playerChoice == "Scissors" && computerchoice == "Paper"->"Player"
        else->"Computer"
    }
    if(winner == "Tie"){
        println("It's a Tie")
    }else{
        println("$winner won!")
    }
}