package com.example.tictactoe_without.model

import androidx.lifecycle.MutableLiveData

abstract class Game (){
    abstract var gameField: MutableLiveData<List<Char>>
    abstract var turn:Boolean
    abstract val charInRow:Int
}