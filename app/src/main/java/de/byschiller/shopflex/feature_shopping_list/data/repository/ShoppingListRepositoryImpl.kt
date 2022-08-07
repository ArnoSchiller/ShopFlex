package de.byschiller.shopflex.feature_shopping_list.data.repository

import de.byschiller.shopflex.feature_shopping_list.data.data_source.ShoppingListDao
import de.byschiller.shopflex.feature_shopping_list.data.dto.ShoppingListDTO
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.repository.ShoppingListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class ShoppingListRepositoryImpl(
    private val dao: ShoppingListDao
) : ShoppingListRepository {
    override fun getShoppingLists(): Flow<List<ShoppingList>> {
        return dao.getShoppingLists().map { shoppingLists ->
            shoppingLists.map { it.dtoToModel() }
        }
    }

    override suspend fun insertShoppingList(list: ShoppingList) {
        dao.insertShoppingList(ShoppingListDTO.modelToDto(list))
    }
}