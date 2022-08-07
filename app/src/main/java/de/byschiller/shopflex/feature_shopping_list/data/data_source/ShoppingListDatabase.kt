package de.byschiller.shopflex.feature_shopping_list.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import de.byschiller.shopflex.feature_shopping_list.data.dto.ShoppingListDTO

@Database(
    entities = [ShoppingListDTO::class],
    version = 1
)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract val noteDao: ShoppingListDao

    companion object {
        const val DATABASE_NAME = "shopping_list_db"
    }
}