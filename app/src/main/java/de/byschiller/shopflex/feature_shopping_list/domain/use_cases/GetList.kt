package de.byschiller.shopflex.feature_shopping_list.domain.use_cases

import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.repository.ShoppingListRepository
import kotlinx.coroutines.flow.Flow

class GetList(
    private val repository: ShoppingListRepository
) {
    operator fun invoke(
        listId: Int
    ): Flow<ShoppingList?> {
        return repository.getList(listId)
    }
}