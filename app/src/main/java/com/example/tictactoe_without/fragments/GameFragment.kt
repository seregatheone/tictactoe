package com.example.tictactoe_without.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.tictactoe_without.databinding.FragmentGameBinding
import com.example.tictactoe_without.model.gametype.MyFactory
import com.example.tictactoe_without.viewmodel.GameViewModel
import org.json.JSONObject
import java.io.IOException

class GameFragment : Fragment() {
    //binding
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<GameFragmentArgs>()

    //game settings
    private var gameField = MutableLiveData(List<Char>(9) { 'n' })
    private var turn: Boolean = false
    private var charInRow:Int = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gameViewFragment = ViewModelProvider(this)[GameViewModel::class.java]
        //creating a game class
        val bundle = args.toBundle()
        val gameMode = bundle.get("gameMode")
        val gameTypeConf = bundle.get("simpleGameType") as Int

        //from here to next TODO
        //gson work
        val jsonFileString = getJsonDataFromAsset(requireContext(), "GameTypes.json")
        val obj = JSONObject(jsonFileString!!)
        val allGameTypes = obj.getJSONArray("gameTypes")

        //get from json or creating a new
        if (gameMode == "old") {
            gameField = MutableLiveData(emptyList())
            for (i in 0..allGameTypes.length()){
                val game = allGameTypes.getJSONObject(i)
                if (game.get("name").toString().toInt()==gameTypeConf){
                    val string = game.get("gameField").toString()
                    val list = emptyList<Char>().toMutableList()
                    for (el in string) {
                        list+=el
                    }
                    gameField =MutableLiveData(list)
                    charInRow = game.get("charInRow").toString().toInt()
                    turn = game.get("turn").toString().toBoolean()
                }
            }
        } else {
            gameField = MutableLiveData(List<Char>(gameTypeConf*gameTypeConf) { 'n' })
            charInRow = 3
            turn = false
        }
        // to here you can cut to another class TODO, return gameWorkProcess

        val gameWorkProcess = MyFactory(gameField,turn,charInRow).gameTypeForComplexity(gameTypeConf)

        gameViewFragment.readAllData.observe(viewLifecycleOwner, {

        })
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
