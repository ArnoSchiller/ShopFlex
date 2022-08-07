package de.byschiller.shopflex.feature_shopping_list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import de.byschiller.shopflex.feature_shopping_list.presentation.shoppingLists.ShoppingListsScreen


fun NavGraphBuilder.shoppingListGraph(navController: NavController) {
    navigation(
        startDestination = ShoppingListNavRoutes.ListsOverview.route,
        route = ShoppingListNavRoutes.baseRoute
    ) {
        composable(ShoppingListNavRoutes.ListsOverview.route) { ShoppingListsScreen(navController) }
    }
}