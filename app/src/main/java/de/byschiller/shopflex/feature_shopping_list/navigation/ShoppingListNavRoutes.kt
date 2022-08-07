package de.byschiller.shopflex.feature_shopping_list.navigation

import de.byschiller.shopflex.R

sealed class ShoppingListNavRoutes(val route: String, val title: Int) {

    companion object {
        const val baseRoute = "shoppingList"
    }

    val absoluteRoute: String = "$baseRoute/$route"
    object ListsOverview : ShoppingListNavRoutes("listsOverview", R.string.shopping_lists_title)
    object ShoppingList : ShoppingListNavRoutes("shoppingList", R.string.shopping_list_title)
}