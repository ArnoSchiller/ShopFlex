package de.byschiller.shopflex.feature_shopping_list.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.byschiller.shopflex.feature_shopping_list.data.data_source.ShoppingListDatabase
import de.byschiller.shopflex.feature_shopping_list.data.repository.ShoppingListRepositoryImpl
import de.byschiller.shopflex.feature_shopping_list.domain.repository.ShoppingListRepository
import de.byschiller.shopflex.feature_shopping_list.domain.use_cases.GetList
import de.byschiller.shopflex.feature_shopping_list.domain.use_cases.GetShoppingLists
import de.byschiller.shopflex.feature_shopping_list.domain.use_cases.InsertShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.use_cases.ShoppingListUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShoppingListModule {

    @Provides
    @Singleton
    fun provideShoppingListDatabase(app: Application): ShoppingListDatabase {
        return Room.databaseBuilder(
            app,
            ShoppingListDatabase::class.java,
            ShoppingListDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideShoppingListRepository(db: ShoppingListDatabase): ShoppingListRepository {
        return ShoppingListRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideShoppingListUseCases(repository: ShoppingListRepository): ShoppingListUseCases {
        return ShoppingListUseCases(
            getShoppingLists = GetShoppingLists(repository),
            getList = GetList(repository),
            insertShoppingList = InsertShoppingList(repository)
        )
    }
}