package de.byschiller.shopflex.feature_shopping_list.presentation.shoppingLists

import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList

data class ShoppingListsState(
    val shoppingLists: List<ShoppingList> = emptyList(),
    //val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)