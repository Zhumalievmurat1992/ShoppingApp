package kg.geektech.shoppingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.domain.entity.ShopItem

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et = findViewById<EditText>(R.id.et)

        viewModel.addShopItem(ShopItem("potato",14,false))




        findViewById<Button>(R.id.btn_delete).setOnClickListener {
            Log.d("myLogs","--------")
            viewModel.removeShopItem(ShopItem(et.text.toString(),14,false))
            Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btn_add).setOnClickListener {
            Log.d("myLogs","+++++++++")
            viewModel.addShopItem(ShopItem(et.text.toString(),14,false))
            Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
        }


        findViewById<Button>(R.id.btn).setOnClickListener {
            Toast.makeText(this,viewModel.getShopList().toString(),Toast.LENGTH_SHORT).show()
        }
    }
}