package de.byschiller.shopflex.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import de.byschiller.shopflex.R
import de.byschiller.shopflex.feature_shopping_list.navigation.ShoppingListNavRoutes

sealed class NavRoutes(val route: String, val title: Int, val icon: ImageVector) {
    object Home : NavRoutes("home", R.string.home_title, Icons.Filled.Home)

    object ShoppingList :
        NavRoutes(ShoppingListNavRoutes.baseRoute, R.string.shopping_lists_title, Icons.Filled.List)
}
