package de.byschiller.shopflex.feature_shopping_list.presentation.manage_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.byschiller.shopflex.feature_shopping_list.domain.model.ListElement
import de.byschiller.shopflex.feature_shopping_list.domain.use_cases.ShoppingListUseCases
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ManageListViewModel @Inject constructor(
    private val shoppingListUseCases: ShoppingListUseCases,
    private val savedState: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ManageListState())
    val state: State<ManageListState> = _state

    private var recentlyDeletedListElement: ListElement? = null

    private var getListJob: Job? = null

    init {

        savedState.get<Int>("listId")?.let {
            getSelectedList(it)
        } ?: run {
            //TODO: handle error case
        }

    }


    fun onEvent(event: ManageListEvent) {
        when (event) {
            is ManageListEvent.AddListElement -> TODO()
            is ManageListEvent.DeleteListElement -> TODO()
            ManageListEvent.RestoreListElement -> TODO()
        }
    }

    private fun getSelectedList(id: Int) {
        getListJob?.cancel()
        getListJob = shoppingListUseCases.getList(id)
            .onEach { list ->
                Log.d("LIST", list.toString())
                _state.value = state.value.copy(
                    selectedList = list
                )
            }
            .launchIn(viewModelScope)
    }
}