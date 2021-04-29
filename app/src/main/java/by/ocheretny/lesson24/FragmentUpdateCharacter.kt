package by.ocheretny.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val plusKills = view.findViewById<TextInputLayout>(R.id.plus_wins)

        val character : Character?  = viewModel.selectedCharacter.value


    }

}