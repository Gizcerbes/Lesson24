package by.ocheretny.lesson24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val characters = ArrayList<Character>()

    val selectedCharacter = MutableLiveData<Character>()

    val updatesCharacter = MutableLiveData<Character>()


}