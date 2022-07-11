package br.com.zup.apprickymorty.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.apprickymorty.R
import br.com.zup.apprickymorty.data.datasource.remote.model.CharacterResult
import br.com.zup.apprickymorty.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso

class CharacterListAdapter(
    private var characterList: MutableList<CharacterResult>,
    private var clickCharacterResult: (character: CharacterResult) -> Unit
    //TODO: clickFavCharResult
    //private var clickFavCharResult: (character: CharacterResult) -> Unit
) :
    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.showCharacterResultInfo(character)
        holder.binding.ivCharacter.setOnClickListener {
            clickCharacterResult(character)
        }
        //TODO: clickFavCharResult
//        holder.binding.ivFavorite.setOnClickListener {
//            character.isFavorite = !character.isFavorite
//            clickFavorite(character)
//    }
            notifyItemChanged(position)

    }

    override fun getItemCount(): Int = characterList.size

    //TODO fun updateCharList Qual usabilidade?
    fun updateCharacterList(newList: MutableList<CharacterResult>) {
        characterList = newList
    }

    class ViewHolder(val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun showCharacterResultInfo(character: CharacterResult) {
            //TODO Acertar url base + character.id + JPEG
            Picasso.get().load(R.drawable.ic_sticker_ricky_morty).into(binding.ivCharacter)
        }

        //TODO FavImageStar()
        //            binding.ivFavorite.setImageDrawable(
        //                ContextCompat.getDrawable(
        //                    binding.root.context,
        //                    if (characterResult.isFavorite)
        //                        R.drawable.ic_favorite
        //                    else
        //                        R.drawable.ic_disfavor
    }
}


