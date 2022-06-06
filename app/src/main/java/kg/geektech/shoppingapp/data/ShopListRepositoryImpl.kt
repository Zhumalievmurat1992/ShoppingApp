package kg.geektech.shoppingapp.data

import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.repository.ShopListRepository

class ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    override fun addShopItem(shopItem: ShopItem) {
        shopList.add(shopItem)
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopList.toString()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        TODO("Not yet implemented")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}