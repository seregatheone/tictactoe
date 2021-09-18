package com.example.tictactoe_without.model.gametype

import androidx.lifecycle.MutableLiveData

class MyFactory(private val gameField: MutableLiveData<List<Char>>, private val turn: Boolean, private val charInRow:Int){
    fun gameTypeForComplexity(gameType: Int): Any {
        return when(gameType){
            //change for others
            3->ThreeGame(gameField,turn,charInRow)
            //for others type of game
//            4->ThreeGame(gameField,turn,charInRow)
//            5->ThreeGame(gameField,turn,charInRow)
            else -> ThreeGame(gameField,turn,charInRow)
        }
    }
}