package com.example.tictactoe_without.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class GameViewModel(application: Application):AndroidViewModel(application) {
    val readAllData : MutableLiveData<List<Char >> by lazy {
        MutableLiveData<List<Char>>()
    }

}