package de.byschiller.shopflex.feature_shopping_list.presentation.manage_list

import de.byschiller.shopflex.feature_shopping_list.domain.model.ListElement

sealed class ManageListEvent {
    data class AddListElement(val element: ListElement) : ManageListEvent()
    data class DeleteListElement(val element: ListElement) : ManageListEvent()
    object RestoreListElement : ManageListEvent()
    //object ToggleOrderSection: ShoppingListsEvent()
    //data class Order(val noteOrder: NoteOrder): NotesEvent()
}