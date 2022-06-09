package kg.geektech.shoppingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.ActivityMainBinding
import kg.geektech.shoppingapp.databinding.ActivitySecondBinding
import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.presentation.adapter.ItemAdapter

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivitySecondBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = ItemAdapter(viewModel.getShopList())

        }
    }
}