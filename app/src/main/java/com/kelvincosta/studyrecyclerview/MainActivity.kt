package com.kelvincosta.studyrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.kelvincosta.studyrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var listGames: ArrayList<Games> = arrayListOf()
    private lateinit var gamesAdapter: GamesAdapter

    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** Desativa o modo escuro */
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        /** Repete 100 vezes a adição desse item na lista.*/
        repeat(100) {
        listGames.add(Games(id, "$id Minecraft"))
        id++
        }

        /**Instanciando o Adapter e atribuindo ao RecyclerView */
        gamesAdapter = GamesAdapter()
        binding.recyclerView.adapter = gamesAdapter

        /** Atribuindo a lista de Games ao Adapter */
        gamesAdapter.submitList(listGames)
    }



}