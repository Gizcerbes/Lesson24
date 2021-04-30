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
    private lateinit var changeName: TextInputLayout
    private lateinit var changePhoto: TextInputLayout
    private lateinit var plusGames: TextInputLayout
    private lateinit var plusWins: TextInputLayout
    private lateinit var plusKills: TextInputLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeName = view.findViewById<TextInputLayout>(R.id.change_name)
        changePhoto = view.findViewById<TextInputLayout>(R.id.change_photo)
        plusGames = view.findViewById<TextInputLayout>(R.id.plus_games)
        plusWins = view.findViewById<TextInputLayout>(R.id.plus_wins)
        plusKills = view.findViewById<TextInputLayout>(R.id.plus_kills)

        view.findViewById<Button>(R.id.character_add_button).setOnClickListener {
            if (verif()) return@setOnClickListener


            val character = Character(
                name = changeName.editText?.text.toString(),
                photoURL = changePhoto.editText?.text.toString(),
                countGames = plusGames.editText?.text.toString().toInt(),
                countKills = plusKills.editText?.text.toString().toInt(),
                countWins = plusWins.editText?.text.toString().toInt()
            )

            viewModel.characters.add(character)
            viewModel.addCharacter.value = character
        }
    }

    private fun verif() : Boolean{
        if (changeName.editText?.text.isNullOrEmpty()) {
            changeName.editText?.error = getString(R.string.error_empty_name)
        } else {
            changeName.editText?.error = null
        }

        if (changePhoto.editText?.text.isNullOrEmpty()) {
            changePhoto.editText?.error = getString(R.string.error_empty_url)
        } else {
            changePhoto.editText?.error = null
        }

        try {
            val i = plusGames.editText?.text.toString().toInt()
            if (i <= 0) {
                plusGames.editText?.error = "Cannot be less than 1"
            } else {
                plusGames.editText?.error = null
            }
        } catch (e: Exception) {
            plusGames.editText?.error = e.toString()
        }

        try {
            val i = plusWins.editText?.text.toString().toInt()
            if (i <= 0) {
                plusWins.editText?.error = "Cannot be less than 1"
            } else {
                plusWins.editText?.error = null
            }
        } catch (e: Exception) {
            plusWins.editText?.error = e.toString()
        }

        try {
            val i = plusKills.editText?.text.toString().toInt()
            if (i <= 0) {
                plusKills.editText?.error = "Cannot be less than 1"
            } else {
                plusKills.editText?.error = null
            }
        } catch (e: Exception) {
            plusKills.editText?.error = e.toString()
        }
        return  !changeName.editText?.error.isNullOrEmpty() ||
                !changePhoto.editText?.error.isNullOrEmpty() ||
                !plusGames.editText?.error.isNullOrEmpty() ||
                !plusWins.editText?.error.isNullOrEmpty() ||
                !plusKills.editText?.error.isNullOrEmpty()
    }



}