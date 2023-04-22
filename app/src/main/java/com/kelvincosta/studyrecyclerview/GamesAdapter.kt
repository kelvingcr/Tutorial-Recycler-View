package com.kelvincosta.studyrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kelvincosta.studyrecyclerview.databinding.ItemGamesAdapterBinding


/**
 * DiffUtil ->
 * Recebe duas lista (oldList e newList), e determina as diferenças entre elas
 * Seja de edição, remoção ou edição dos itens.
 *
 * Quando usar?
 * Você só precisa usar o DiffUtil quando a lista que você está exibindo pode mudar dinamicamente em tempo de execução.
 * Se a lista for fixa, não há necessidade de usar o DiffUtil.
 */


/**
 * Vantagens
 * Não precisa deixa implícito  no construtor do Adapter uma lista, ela é mantida internamente no adapter
 * Melhora o desempenho da lista, Ele então calcula as diferenças entre as duas listas e fornece uma lista de operações de atualização
 * Mais eficiência e precisão
 *
 * Eliminaremos o notifyDataSetChanged(), pois ao avisar assim o recyclerview, o recyclerview
 * apaga todas a lista e recria uma nova, imagine se fosse uma lista gigante? isso iria requerer muito mais do aparelho do usuario
 * e consequentemente diminuindo a performance da lista (fluidez)
 *
 */
class GamesAdapter : ListAdapter<Games, GamesAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Games>() {
            override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
                return newItem.id ==  oldItem.id && newItem.name == oldItem.name
            }

        }
    }

    /**
     * Esse método é chamado pelo RecyclerView quando ele precisa criar uma nova instância de ViewHolder para exibir um novo item da lista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGamesAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    /**
     * Esse método é chamado pelo RecyclerView para atualizar o ViewHolder com os dados correspondentes de um item da lista.
     * Nesse método, você deve obter os dados do item da lista a partir da posição especificada e atualizar os elementos da view correspondentes no ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.textGameName.text = item.name
    }

    /**
     * Essa classe representa uma instância de uma view usada para exibir um item da lista.
     * O ViewHolder contém as referências para os elementos da view (por exemplo, um TextView para exibir o nome do usuário)
     * e é responsável por atualizar a view com os dados correspondentes do item da lista.
     */
    inner class ViewHolder(val binding: ItemGamesAdapterBinding) : RecyclerView.ViewHolder(binding.root)
}
