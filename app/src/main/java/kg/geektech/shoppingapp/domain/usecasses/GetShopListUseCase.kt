package kg.geektech.shoppingapp.domain.usecasses

import kg.geektech.shoppingapp.domain.repository.ShopListRepository

class GetShopListUseCase(private val repository: ShopListRepository) {
    fun getShopList() = repository.getShopList()

}