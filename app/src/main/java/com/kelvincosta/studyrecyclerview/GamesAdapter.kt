package com.kelvincosta.studyrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelvincosta.studyrecyclerview.databinding.ItemGamesAdapterBinding

class GamesAdapter() : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    private var gameList = mutableListOf<Games>()

    fun submitList(list: List<Games>) {
        this.gameList = list.toMutableList()
        notifyDataSetChanged()
    }

    /**Esse método é chamado pelo RecyclerView quando ele precisa criar uma nova instância de ViewHolder para exibir um novo item da lista.*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemGamesAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    /** Esse método é responsável por retornar o número de itens na lista que serão exibidos no RecyclerView.
     *  O método getItemCount deve retornar um inteiro que representa o número total de itens na lista.
     *  Esse número será usado pelo RecyclerView para determinar o número de linhas ou colunas necessárias para exibir todos os itens da lista.
     */
    override fun getItemCount(): Int = gameList.size


    /**
     * Esse método é chamado pelo RecyclerView para atualizar o ViewHolder com os dados correspondentes de um item da lista.
     * Nesse método, você deve obter os dados do item da lista a partir da posição especificada e atualizar os elementos da view correspondentes no ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = gameList[position]

        holder.binding.apply {
            textGameName.text = game.name
        }
    }

    /** Essa classe representa uma instância de uma view usada para exibir um item da lista.
     * O ViewHolder contém as referências para os elementos da view (por exemplo, um TextView para exibir o nome do usuário)
     * e é responsável por atualizar a view com os dados correspondentes do item da lista.
     * Ele é criado no método onCreateViewHolder() e é passado para o método onBindViewHolder() para ser atualizado com os dados do item da lista.
     * */
    inner class ViewHolder(val binding: ItemGamesAdapterBinding) : RecyclerView.ViewHolder(binding.root)

}