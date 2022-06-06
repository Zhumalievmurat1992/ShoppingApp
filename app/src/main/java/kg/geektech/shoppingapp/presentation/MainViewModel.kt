package kg.geektech.shoppingapp.presentation

import android.text.Editable
import androidx.lifecycle.ViewModel
import kg.geektech.shoppingapp.data.ShopListRepositoryImpl
import kg.geektech.shoppingapp.domain.entity.ShopItem
import kg.geektech.shoppingapp.domain.usecasses.AddShopItemUseCase
import kg.geektech.shoppingapp.domain.usecasses.EditShopItemUseCase
import kg.geektech.shoppingapp.domain.usecasses.GetShopListUseCase
import kg.geektech.shoppingapp.domain.usecasses.RemoveShopItemUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)


    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)

    }

    fun getShopList() = getShopListUseCase.getShopList()

    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem){
        editShopItemUseCase.editShopItem(shopItem)
    }




}