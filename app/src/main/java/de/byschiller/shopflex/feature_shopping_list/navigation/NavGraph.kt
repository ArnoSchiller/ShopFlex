package de.byschiller.shopflex.feature_shopping_list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import de.byschiller.shopflex.feature_shopping_list.presentation.manage_list.ManageListScreen
import de.byschiller.shopflex.feature_shopping_list.presentation.shoppingLists.ShoppingListsScreen


fun NavGraphBuilder.shoppingListGraph(navController: NavController) {
    navigation(
        startDestination = ListNavRoutes.ListsOverview.route,
        route = ListNavRoutes.baseRoute
    ) {
        composable(ListNavRoutes.ListsOverview.route) { ShoppingListsScreen(navController) }
        composable(
            route = ListNavRoutes.ManageList.route + "?listId={listId}",
            arguments = listOf(navArgument("listId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) { ManageListScreen(navController) }
    }
}