package de.byschiller.shopflex.feature_shopping_list.presentation.shoppingLists

import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList

sealed class ShoppingListsEvent {
    data class AddShoppingList(val list: ShoppingList) : ShoppingListsEvent()
    data class DeleteShoppingList(val list: ShoppingList) : ShoppingListsEvent()
    object RestoreShoppingList : ShoppingListsEvent()
    //object ToggleOrderSection: ShoppingListsEvent()
    //data class Order(val noteOrder: NoteOrder): NotesEvent()
}