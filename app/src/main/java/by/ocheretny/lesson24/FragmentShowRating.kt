package by.ocheretny.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentShowRating : Fragment() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(
            MainViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val charactersAdapter = CharacterAdapter(viewModel)

        recycler.adapter = charactersAdapter

        view.findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {
            findNavController().navigate(R.id.navigation_add_character)
        }

        val spinner: Spinner = view.findViewById(R.id.sort_spinner)
        ArrayAdapter.createFromResource(
            view.context,
            R.array.sort_array,
            android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = it
        }

        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2){
                    0 -> viewModel.characters.sortByDescending { it.name }
                    1 -> viewModel.characters.sortByDescending { it.countGames }
                    2 -> viewModel.characters.sortByDescending { it.countKills }
                    3 -> viewModel.characters.sortByDescending { it.countWins }
                    4 -> viewModel.characters.sortByDescending { it.winReit }
                    5 -> viewModel.characters.sortByDescending { it.kD }
                }
                charactersAdapter.notifyDataSetChanged()
            }
        }
    }


}