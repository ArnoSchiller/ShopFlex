package de.byschiller.shopflex.feature_shopping_list.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingListCategory
import java.util.*

@Entity
data class ShoppingListDTO(
    @PrimaryKey val id: Int? = null,
    val name: String,
    val description: String,
    val category: Int,
    val createdTimestamp: Long
) {
    fun dtoToModel(): ShoppingList {
        return ShoppingList(
            id = id,
            name = name,
            description = description,
            category = ShoppingListCategory.values().first { it.id == category },
            createdTimestamp = createdTimestamp
        )
    }

    companion object {
        fun modelToDto(list: ShoppingList): ShoppingListDTO {
            return ShoppingListDTO(
                id = list.id,
                name = list.name,
                description = list.description,
                category = list.category.id,
                createdTimestamp = list.createdTimestamp,
            )
        }
    }
}