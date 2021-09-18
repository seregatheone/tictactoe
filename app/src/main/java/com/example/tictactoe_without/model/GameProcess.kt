package com.example.tictactoe_without.model

import androidx.lifecycle.MutableLiveData

interface GameProcess {
    fun checkGameOver(gameField: MutableLiveData<List<Char>>,charInRow:Int)
    fun setGamePlace(gameField: MutableLiveData<List<Char>>)
}