package by.ocheretny.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentShowRating : Fragment() {
    val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frafment_show_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val charactersAdapter = CharacterAdapter(viewModel)

        recycler.adapter = charactersAdapter

        view.findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {
            viewModel.openAddFragment.value = Unit
        }


    }


}