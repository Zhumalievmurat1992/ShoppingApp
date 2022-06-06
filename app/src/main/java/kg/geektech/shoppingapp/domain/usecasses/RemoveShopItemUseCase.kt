package kg.geektech.shoppingapp.domain.usecasses

import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.repository.ShopListRepository

class RemoveShopItemUseCase(private val repository: ShopListRepository) {
    fun removeShopItem(shopItem: ShopItem){
        repository.removeShopItem(shopItem)
    }
}