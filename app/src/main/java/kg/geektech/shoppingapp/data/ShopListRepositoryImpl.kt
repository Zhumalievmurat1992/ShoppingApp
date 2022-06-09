package kg.geektech.shoppingapp.data

import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.repository.ShopListRepository
import kotlin.random.Random

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({ o2, o1 ->
        o1.id.compareTo(o2.id)
    })

    private var autoIncrementId = 0

    init {
        for (i in 0..100) {
            addShopItem(ShopItem(1,"tomato", i, false))
            getShopList().toList()
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id == autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        removeShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { item ->
            item.id == shopItemId
        } ?: throw RuntimeException("Element not found $shopItemId ")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}