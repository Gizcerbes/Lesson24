package by.ocheretny.lesson24

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterAdapter(val viewModel: MainViewModel) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    inner class CharacterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun setData(itemView: View, character: Character) {
            Picasso.get().load(character.photoURL)
                .into(itemView.findViewById<ImageView>(R.id.photo))
            itemView.findViewById<TextView>(R.id.name).text = character.name
            itemView.findViewById<TextView>(R.id.kills).text = "${view.context.getString(R.string.kills)} ${character.countKills.toString()}"
            itemView.findViewById<TextView>(R.id.win_reit).text = "${view.context.getString(R.string.percentageOfWins)} ${ String.format("%.2f", character.winReit )  }  ${view.context.getString(R.string.percent)}"
            itemView.findViewById<TextView>(R.id.kills_deaths).text = "${view.context.getString(R.string.KD)} ${String.format("%.2f", character.kD)}  "
            itemView.findViewById<ConstraintLayout>(R.id.character_container).setOnClickListener {
                viewModel.selectedCharacter.value = character
                view.findNavController().navigate(R.id.navigation_update_character)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.setData(holder.itemView, viewModel.characters.get(position))
    }

    override fun getItemCount(): Int {
        return viewModel.characters.size
    }
}