package com.example.tictactoe_without.data

import androidx.lifecycle.MutableLiveData

class DataHandler : DataSaver {
    override suspend fun saveData(
        gameType: String,
        allData: MutableLiveData<List<Char>>,
        turn: Boolean
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getData(name: Int) {
        TODO("Not yet implemented")
    }


}