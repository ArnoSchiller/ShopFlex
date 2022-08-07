package de.byschiller.shopflex.feature_shopping_list.domain.use_cases

data class ShoppingListUseCases(
    val getShoppingLists: GetShoppingLists,
    val insertShoppingList: InsertShoppingList,
    val getList: GetList
)