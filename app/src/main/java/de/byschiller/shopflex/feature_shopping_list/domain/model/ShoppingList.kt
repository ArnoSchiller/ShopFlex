package de.byschiller.shopflex.feature_shopping_list.domain.model

import androidx.compose.ui.graphics.Color

data class ShoppingList(
    val id: Int?,
    val name: String,
    val description: String,
    val category: ShoppingListCategory,
    val createdTimestamp: Long
)


enum class ShoppingListCategory(val id: Int, val color: Color) {
    RedCategory(0, Color.Red),
    GreenCategory(1, Color.Green),
    BlueCategory(2, Color.Blue),
    YellowCategory(3, Color.Yellow),
    MagentaCategory(4, Color.Magenta);

    private val categoryNames = listOf("RED", "GREEN", "BLUE", "YELLOW", "MAGENTA")
    fun getName(): String {
        return categoryNames.get(index = id)
    }
}

class InvalidShoppingListException(message: String) : Exception(message)