package by.ocheretny.lesson24

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class CharacterAdapter(val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(itemView: View, position: Int) {
             val character = characters[position]
            Picasso.get().load(character.photoURL).into(itemView.findViewById<ImageView>(R.id.photo))
            itemView.findViewById<TextView>(R.id.name).text = character.name
            itemView.findViewById<TextView>(R.id.win_reit).text = character.winReit.toString()
            itemView.findViewById<TextView>(R.id.kills_deaths).text = character.kD.toString()
            itemView.findViewById<ConstraintLayout>(R.id.character_container).setOnClickListener{

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.setData(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}