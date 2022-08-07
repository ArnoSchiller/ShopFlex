package de.byschiller.shopflex.feature_shopping_list.presentation.shoppingLists

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.use_cases.ShoppingListUseCases
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListsViewModel @Inject constructor(
    private val shoppingListUseCases: ShoppingListUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ShoppingListsState())
    val state: State<ShoppingListsState> = _state

    private var recentlyDeletedShoppingList: ShoppingList? = null

    private var getShoppingListsJob: Job? = null

    init {
        getShoppingLists()
    }


    fun onEvent(event: ShoppingListsEvent) {
        when (event) {

            is ShoppingListsEvent.DeleteShoppingList -> {
                viewModelScope.launch {
                    //noteUseCases.deleteNote(event.note)
                    //recentlyDeletedNote = event.note
                }
            }
            is ShoppingListsEvent.RestoreShoppingList -> {
                viewModelScope.launch {
                    //noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    //recentlyDeletedNote = null
                }
            }
            is ShoppingListsEvent.AddShoppingList -> {
                viewModelScope.launch {
                    shoppingListUseCases.insertShoppingList(list = event.list)
                    getShoppingLists()
                }
            }
        }
    }

    private fun getShoppingLists() {
        getShoppingListsJob?.cancel()
        getShoppingListsJob = shoppingListUseCases.getShoppingLists()
            .onEach { lists ->
                Log.d("LIST", lists.toString())
                _state.value = state.value.copy(
                    shoppingLists = lists
                )
            }
            .launchIn(viewModelScope)
    }
}