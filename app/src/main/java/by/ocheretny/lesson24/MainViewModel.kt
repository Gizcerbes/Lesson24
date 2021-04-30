package by.ocheretny.lesson24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val characters = ArrayList<Character>().apply {
        add(
            Character(
                "Рэйф",
                "https://www.mordeo.org/files/uploads/2019/03/Wraith-Apex-Legends-4K-Ultra-HD-Mobile-Wallpaper-950x1689.jpg",
                100,
                150,
                10
            )
        )
    }

    val selectedCharacter = MutableLiveData<Character>()

    val updatesCharacter = MutableLiveData<Character>()

    val addCharacter = MutableLiveData<Character>()

    val openAddFragment = MutableLiveData<Unit>()

}