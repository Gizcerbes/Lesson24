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
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }
    private lateinit var changePhoto: TextInputLayout
    private lateinit var plusGames: TextInputLayout
    private lateinit var plusWins: TextInputLayout
    private lateinit var plusKills: TextInputLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_character, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changePhoto = view.findViewById(R.id.change_photo)
        plusGames = view.findViewById(R.id.plus_games)
        plusWins = view.findViewById(R.id.plus_wins)
        plusKills = view.findViewById(R.id.plus_kills)
        val character: Character = viewModel.selectedCharacter.value ?: Character("","")

        changePhoto.editText?.setText(character.photoURL.toString())
        plusGames.editText?.setText("0")
        plusWins.editText?.setText("0")
        plusKills.editText?.setText("0")

        view.findViewById<Button>(R.id.character_update_button).setOnClickListener {
            if (verif()) return@setOnClickListener

            character.photoURL = changePhoto.editText?.text.toString()
            character.countGames += plusGames.editText?.text.toString().toInt()
            character.countKills += plusKills.editText?.text.toString().toInt()
            character.countWins += plusWins.editText?.text.toString().toInt()

            activity?.supportFragmentManager?.popBackStack()
        }


    }

    private fun verif(): Boolean {
        if (changePhoto.editText?.text.isNullOrEmpty()) {
            changePhoto.editText?.error = getString(R.string.error_empty_field)
        } else {
            changePhoto.editText?.error = null
        }

        try {
            val i = plusGames.editText?.text.toString().toInt()
            if (i < 0) {
                plusGames.editText?.error = getString(R.string.not_be_less_than_0)
            } else {
                plusGames.editText?.error = null
            }
        } catch (e: NumberFormatException) {
            plusGames.editText?.error = getString(R.string.error_empty_field)
        } catch (e: Exception) {
            plusGames.editText?.error = e.toString()
        }

        try {
            val i = plusWins.editText?.text.toString().toInt()
            if (i < 0) {
                plusWins.editText?.error = getString(R.string.not_be_less_than_0)
            } else {
                plusWins.editText?.error = null
            }
        } catch (e: NumberFormatException) {
            plusWins.editText?.error = getString(R.string.error_empty_field)
        } catch (e: Exception) {
            plusWins.editText?.error = e.toString()
        }

        try {
            val i = plusKills.editText?.text.toString().toInt()
            if (i < 0) {
                plusKills.editText?.error = getString(R.string.not_be_less_than_0)
            } else {
                plusKills.editText?.error = null
            }
        } catch (e: NumberFormatException) {
            plusKills.editText?.error = getString(R.string.error_empty_field)
        } catch (e: Exception) {
            plusKills.editText?.error = e.toString()
        }
        return !changePhoto.editText?.error.isNullOrEmpty() ||
                !plusGames.editText?.error.isNullOrEmpty() ||
                !plusWins.editText?.error.isNullOrEmpty() ||
                !plusKills.editText?.error.isNullOrEmpty()
    }
}