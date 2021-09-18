package com.example.tictactoe_without.model.gametype

import androidx.lifecycle.MutableLiveData
import com.example.tictactoe_without.model.Game
import com.example.tictactoe_without.model.GameProcess

class ThreeGame(override var gameField: MutableLiveData<List<Char>>, override var turn: Boolean,override val charInRow:Int) : Game(),GameProcess {
    override fun checkGameOver(gameField: MutableLiveData<List<Char>>, charInRow: Int) {
        TODO("Not yet implemented")
    }

    override fun setGamePlace(gameField: MutableLiveData<List<Char>>) {
        this.gameField = gameField
    }
    //simple game == 3x3

}