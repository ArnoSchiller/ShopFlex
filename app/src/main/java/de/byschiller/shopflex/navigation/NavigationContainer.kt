package de.byschiller.shopflex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.byschiller.shopflex.Home
import de.byschiller.shopflex.feature_shopping_list.navigation.shoppingListGraph

@Composable
fun NavigationContainer() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        //val uri = "https://www.example.com"

        composable(NavRoutes.Home.route) {
            Home(navController = navController)
        }
        shoppingListGraph(navController)
    }
}