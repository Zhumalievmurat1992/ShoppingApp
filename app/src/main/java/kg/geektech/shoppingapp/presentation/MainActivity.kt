package kg.geektech.shoppingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.ActivityMainBinding
import kg.geektech.shoppingapp.domain.entity.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()


    }

    private fun initListeners() {
        binding.apply {
            btnAdd.setOnClickListener {
                viewModel.addShopItem(ShopItem(1,"potato", 2, false))
            }
            btnDelete.setOnClickListener {
                viewModel.removeShopItem(ShopItem(1,"potato", 2, false))
            }
            btnEdit.setOnClickListener {
                viewModel.editShopItem(ShopItem(1,"tomato", 14, false, 14))
            }
            btn.setOnClickListener {
                Log.e("TAG", "initListeners: ${viewModel.getShopList()}")
            }
        }
    }
}