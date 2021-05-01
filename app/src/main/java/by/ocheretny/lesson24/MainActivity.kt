package by.ocheretny.lesson24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
const val BACK_STACK = "BACK STACK"
class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentShowRating()).commit()

        viewModel.selectedCharacter.observe(this){
            supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentUpdateCharacter()).addToBackStack(BACK_STACK).commit()
        }

        viewModel.updatesCharacter.observe(this){
            supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentShowRating()).commit()
        }


        viewModel.openAddFragment.observe(this){
            supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentAddCharacter()).addToBackStack(BACK_STACK).commit()
        }

    }
}