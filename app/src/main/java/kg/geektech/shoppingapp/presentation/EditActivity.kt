package kg.geektech.shoppingapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.ActivityEditBinding
import kg.geektech.shoppingapp.databinding.ActivityMainBinding

@EntryPoint
class EditActivity : AppCompatActivity(R.layout.activity_edit) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityEditBinding by viewBinding()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.saveBtn.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("key", binding.dataEt.text.toString()))
            //setResult(RESULT_OK, Intent().putExtra("Key2", binding.countEt.text.toString()))
            finish()
        }
    }
}