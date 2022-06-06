package kg.geektech.shoppingapp.domain.usecasses

import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.repository.ShopListRepository

class EditShopItemUseCase(private val repository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem)
    }
}