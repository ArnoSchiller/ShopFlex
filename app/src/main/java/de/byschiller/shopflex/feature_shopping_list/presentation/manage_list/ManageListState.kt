package de.byschiller.shopflex.feature_shopping_list.presentation.manage_list

import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList

data class ManageListState(
    val selectedList: ShoppingList? = null,
    val isOrderSectionVisible: Boolean = false
)