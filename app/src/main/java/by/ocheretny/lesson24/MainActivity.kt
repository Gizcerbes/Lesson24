package by.ocheretny.lesson24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe

class MainActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentShowRating()).commit()

        viewModel.selectedCharacter.observe(this){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentUpdateCharacter()).commit()
        }

    }
}