package by.ocheretny.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class FragmentAddCharacter : Fragment() {

    val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changeName = view.findViewById<TextInputLayout>(R.id.change_name)
        val changePhoto = view.findViewById<TextInputLayout>(R.id.change_photo)
        val plusGames = view.findViewById<TextInputLayout>(R.id.plus_games)
        val plusWins = view.findViewById<TextInputLayout>(R.id.plus_wins)
        val plusKills = view.findViewById<TextInputLayout>(R.id.plus_kills)

        view.findViewById<Button>(R.id.character_add_button).setOnClickListener {
            val character = Character(
                changeName.editText?.text.toString(),
                changePhoto.editText?.text.toString(),
                plusGames.editText?.text.toString().toInt(),
                plusKills.editText?.text.toString().toInt(),
                plusWins.editText?.text.toString().toInt()
            )
            viewModel.characters.add(character)
            viewModel.addCharacter.value = character
        }

    }

}