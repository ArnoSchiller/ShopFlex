package de.byschiller.shopflex.feature_shopping_list.presentation.manage_list.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.byschiller.shopflex.feature_shopping_list.domain.model.ListElement

@Composable
fun ListElementItem(
    element: ListElement,
    modifier: Modifier
) {
    Text(element.name)
}