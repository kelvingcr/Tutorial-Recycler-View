package com.kelvincosta.studyrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.kelvincosta.studyrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: GamesAdapter
    private var listGames: ArrayList<Games> = arrayListOf()
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = GamesAdapter()
        binding.recyclerView.adapter = adapter

        /** Repite 100 vezes */
        repeat(100) {
            listGames.add(Games(id, " $id Minecraft"))
            id++
        }

        /** Envia a lista para Adapter */
        adapter.submitList(listGames)

        /** Desativa o modo escuro */
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}