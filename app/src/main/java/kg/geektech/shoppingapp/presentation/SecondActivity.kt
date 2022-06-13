package kg.geektech.shoppingapp.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.ActivityMainBinding
import kg.geektech.shoppingapp.databinding.ActivitySecondBinding
import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.presentation.adapter.ItemAdapter

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivitySecondBinding by viewBinding()
    private val adapter = ItemAdapter()
    private var text = ""
    private var count = Int
    private lateinit var startForResult: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListeners()
        initRecycler()

        startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data?.getStringExtra("Key")
                text = intent.toString()
                viewModel.addShopItem(ShopItem(text, 0, true))
            }
        }
    }

    private fun initListeners() {
        binding.addBtn.setOnClickListener {
//            Intent(this,EditActivity::class.java)
           startForResult.launch(Intent(this,EditActivity::class.java))

        }

    }

    private fun initRecycler() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        viewModel.getShopList().observe(this) {
            adapter.setList(it)
        }


        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.shopList[viewHolder.absoluteAdapterPosition]
                viewModel.removeShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.recycler)
    }

}