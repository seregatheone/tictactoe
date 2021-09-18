package com.example.tictactoe_without.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.tictactoe_without.R
import com.example.tictactoe_without.databinding.FragmentStartBinding
import com.example.tictactoe_without.model.gametype.ThreeGame

class StartFragment : Fragment() {

    //binding
    private var _binding:FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)

        //set gameType
        val simpleGameType = 3
        val bundle = bundleOf("simpleGameType" to simpleGameType)
        val action = StartFragmentDirections.actionStartFragmentToGameFragment()
        var gameMode = "new"
        //Buttons
        binding.startGame.setOnClickListener {
            bundle.putString("gameMode",gameMode)
            action.arguments.putBundle("bundle",bundle)
            findNavController().navigate(action)
        }
        binding.continueGame.setOnClickListener {
            gameMode = "old"
            bundle.putString("gameMode",gameMode)
            action.arguments.putBundle("bundle",bundle)
            findNavController().navigate(action)
        }
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}