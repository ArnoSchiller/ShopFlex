package de.byschiller.shopflex.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import de.byschiller.shopflex.R
import de.byschiller.shopflex.feature_shopping_list.navigation.ListNavRoutes

sealed class NavRoutes(val route: String, val title: Int, val icon: ImageVector) {
    object Home : NavRoutes("home", R.string.home_title, Icons.Filled.Home)

    object ShoppingList :
        NavRoutes(ListNavRoutes.baseRoute, R.string.shopping_lists_title, Icons.Filled.List)
}
