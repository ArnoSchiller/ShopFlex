package de.byschiller.shopflex.feature_shopping_list.domain.use_cases

import de.byschiller.shopflex.feature_shopping_list.domain.model.InvalidShoppingListException
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.repository.ShoppingListRepository

class InsertShoppingList(
    private val repository: ShoppingListRepository
) {
    @Throws(InvalidShoppingListException::class)
    suspend operator fun invoke(list: ShoppingList) {
        if (list.name.isBlank()) {
            throw InvalidShoppingListException("The title of the shopping list can't be empty.")
        }
        repository.insertShoppingList(list)
    }
}