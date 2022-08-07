package de.byschiller.shopflex.feature_shopping_list.navigation

import de.byschiller.shopflex.R

sealed class ListNavRoutes(relRoute: String, val title: Int) {

    companion object {
        const val baseRoute = "shoppingList"
    }

    val route: String = "$baseRoute/$relRoute"

    object ListsOverview : ListNavRoutes("listsOverview", R.string.shopping_lists_title)
    object ManageList : ListNavRoutes("manageList", R.string.manage_list_title)
}