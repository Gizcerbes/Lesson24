package by.ocheretny.lesson24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewModelProvider(this).get

        supportFragmentManager.beginTransaction().replace(R.id.conteiner_main, FragmentShowRating())

    }
}