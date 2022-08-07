package de.byschiller.shopflex.feature_shopping_list.domain.repository

import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {

    fun getShoppingLists(): Flow<List<ShoppingList>>
    fun getList(listId: Int): Flow<ShoppingList?>

    suspend fun insertShoppingList(list: ShoppingList)
}