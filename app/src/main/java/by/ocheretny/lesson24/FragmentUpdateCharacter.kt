package by.ocheretny.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class FragmentUpdateCharacter : Fragment() {
    val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_update_character, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changePhoto = view.findViewById<TextInputLayout>(R.id.change_photo)
        val plusGames = view.findViewById<TextInputLayout>(R.id.plus_games)
        val plusWins = view.findViewById<TextInputLayout>(R.id.plus_wins)
        val plusKills = view.findViewById<TextInputLayout>(R.id.plus_kills)

        val character : Character?  = viewModel.selectedCharacter.value

        changePhoto.editText?.setText(character?.photoURL)
        plusGames.editText?.setText("0")
        plusWins.editText?.setText("0")
        plusKills.editText?.setText("0")

        view.findViewById<Button>(R.id.character_update_button).setOnClickListener {
            character?.photoURL = changePhoto.editText?.text.toString()
            character?.countGames = character?.countGames?.plus(plusGames.editText?.text.toString().toInt())!!
            character?.countKills = character?.countKills?.plus(plusKills.editText?.text.toString().toInt())!!
            character?.countWins = character?.countWins?.plus(plusWins.editText?.text.toString().toInt())!!
        }
    }
}