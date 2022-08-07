package de.byschiller.shopflex.feature_shopping_list.domain.use_cases

import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.repository.ShoppingListRepository
import kotlinx.coroutines.flow.Flow

class GetShoppingLists(
    private val repository: ShoppingListRepository
) {
    operator fun invoke(
        //noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<ShoppingList>> {
        return repository.getShoppingLists()/*.map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }*/
    }
}