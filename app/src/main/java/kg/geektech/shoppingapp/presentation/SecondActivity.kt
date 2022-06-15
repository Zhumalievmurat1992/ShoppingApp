package kg.geektech.shoppingapp.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.viewModels
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.ActivitySecondBinding
import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.presentation.adapter.ItemAdapter
import kotlin.Int.Companion as Int

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivitySecondBinding by viewBinding()
    private val adapter = ItemAdapter()
    private var text = ""
    private var count = 0
    private lateinit var startForResult: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startForResult = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data?.getStringExtra("key")
               // val intent2 = result.data?.getIntExtra("key",count)
                text = intent.toString()
//                if (intent2 != null) {
//                    count = intent2.toInt()
//                }
                viewModel.addShopItem(
                    ShopItem(text, 0, true)
                )
            }
        }

        initRecycler()
    }

    private fun initListeners() {
        binding.addBtn.setOnClickListener {
           startForResult.launch(Intent(this,EditActivity::class.java))
        }
    }

    private fun initRecycler() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        viewModel.getShopList().observe(this) {
            adapter.setList(it)
        }
        initListeners()

        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: kotlin.Int) {
                val item = adapter.shopList[viewHolder.absoluteAdapterPosition]
                viewModel.removeShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.recycler)
    }

}