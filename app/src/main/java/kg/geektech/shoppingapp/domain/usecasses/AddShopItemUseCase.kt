package kg.geektech.shoppingapp.domain.usecasses

import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.repository.ShopListRepository

class AddShopItemUseCase(private val repository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem){
        repository.addShopItem(shopItem)
    }
}