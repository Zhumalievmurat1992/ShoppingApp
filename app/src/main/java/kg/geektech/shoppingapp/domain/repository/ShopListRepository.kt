package kg.geektech.shoppingapp.domain.repository

import androidx.lifecycle.LiveData
import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.usecasses.EditShopItemUseCase

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun removeShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    //refactor
    fun getShopList(): LiveData<List<ShopItem>>
}