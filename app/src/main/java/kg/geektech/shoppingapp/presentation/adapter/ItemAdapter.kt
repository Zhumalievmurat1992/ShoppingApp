package kg.geektech.shoppingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.Item1Binding
import kg.geektech.shoppingapp.databinding.Item2Binding
import kg.geektech.shoppingapp.domain.entity.ShopItem

//private const val VIEW_TYPE_ONE:Int = 0
//private const val VIEW_TYPE_TWO:Int = 1


class ItemAdapter(val elements: List<ShopItem>):
    RecyclerView
    .Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private var list = ArrayList<ShopItem>()




    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = Item1Binding.bind(itemView)
        fun bind(shopItem: ShopItem) = with(binding) {
            println("---------")
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
        }

    }

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = Item2Binding.bind(itemView)
        fun bind(shopItem: ShopItem) = with(binding) {
            elements.random()
            println("+++++++++")
            tvName2.text = shopItem.name
            tvCount2.text = shopItem.count.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item1, parent, false))

        } else ViewHolder2(LayoutInflater.from(parent.context)
            .inflate(R.layout.item2,parent,false))
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].viewType == 0) {
            VIEW_TYPE_ONE
        } else {
            VIEW_TYPE_TWO
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_ONE) {
            (holder as ViewHolder).bind(list[position])
        } else {
            (holder as ViewHolder2).bind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}