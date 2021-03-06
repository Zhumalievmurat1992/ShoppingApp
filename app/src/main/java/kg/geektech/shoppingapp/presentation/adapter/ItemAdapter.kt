package kg.geektech.shoppingapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.shoppingapp.R
import kg.geektech.shoppingapp.databinding.Item1Binding
import kg.geektech.shoppingapp.databinding.Item2Binding
import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.presentation.ShopListDiffCallback

class ItemAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private var list = listOf<ShopItem>()
    var shopList = listOf<ShopItem>()


    inner class ViewHolder(private val binding: Item2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shopItem: ShopItem) {
            binding.tvName2.text = shopItem.name
            binding.tvCount2.text = shopItem.count.toString()
            binding.root.setOnLongClickListener{
                onShopItemLongClickListener?.invoke(shopItem)
                true
            }
        }

    }

    inner class ViewHolder2(private val binding: Item1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shopItem: ShopItem) = with(binding) {
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_TWO -> {
                return ViewHolder(
                    Item2Binding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_TYPE_ONE -> {
                return ViewHolder2(
                    Item1Binding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                throw RuntimeException("Not found")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].enable) {
            VIEW_TYPE_TWO
        } else {
            VIEW_TYPE_ONE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == VIEW_TYPE_TWO) {
            (holder as ViewHolder).bind(list[position])
        } else {
            (holder as ViewHolder2).bind(list[position])
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ShopItem>) {
        this.list = list
        this.shopList = list
        notifyDataSetChanged()
        val callback = ShopListDiffCallback(this.list, list)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)
    }
}
