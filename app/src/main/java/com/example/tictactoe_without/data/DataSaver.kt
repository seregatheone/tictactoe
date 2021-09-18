package com.example.tictactoe_without.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface DataSaver {
    suspend fun saveData(gameType:String,allData: MutableLiveData<List<Char>>,turn:Boolean)
    suspend fun getData(name:Int)
}