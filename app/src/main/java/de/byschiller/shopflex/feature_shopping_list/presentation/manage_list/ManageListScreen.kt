package de.byschiller.shopflex.feature_shopping_list.presentation.manage_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.byschiller.shopflex.feature_shopping_list.presentation.manage_list.components.ListElementItem
import de.byschiller.shopflex.navigation.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageListScreen(
    navController: NavController,
    viewModel: ManageListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.selectedList?.let { list ->

        Scaffold(
            bottomBar = { BottomNavBar(navController = navController) },
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = list.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    navigationIcon = {
                        Icon(
                            Icons.Default.ArrowBack,
                            "back",
                            modifier = Modifier.clickable(onClick = { navController.popBackStack() })
                        )
                    }
                )
            },

            ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    itemsIndexed(list.listElements) { index, element ->
                        ListElementItem(
                            element = element,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    } ?: run {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "loading ...",
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    navigationIcon = {
                        Icon(
                            Icons.Default.ArrowBack,
                            "back",
                            modifier = Modifier.clickable(onClick = { navController.popBackStack() })
                        )
                    }
                )
            },

            ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column {

                    CircularProgressIndicator()
                    Text(text = "wait a minute", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}