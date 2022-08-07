package de.byschiller.shopflex.feature_shopping_list.data.data_source

import androidx.room.*
import de.byschiller.shopflex.feature_shopping_list.data.dto.ShoppingListDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {

    @Query("SELECT * FROM shoppinglistdto")
    fun getShoppingLists(): Flow<List<ShoppingListDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(note: ShoppingListDTO)
}