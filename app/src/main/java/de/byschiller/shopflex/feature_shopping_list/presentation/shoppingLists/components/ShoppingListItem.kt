package de.byschiller.shopflex.feature_shopping_list.presentation.shoppingLists.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingList
import de.byschiller.shopflex.feature_shopping_list.domain.model.ShoppingListCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListItem(
    list: ShoppingList,
    modifier: Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = list.name,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )

                ElevatedAssistChip(
                    modifier = Modifier.height(24.dp),
                    onClick = {},
                    enabled = false,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Sell,
                            contentDescription = "category",
                            modifier = Modifier.fillMaxHeight(0.7f),
                            tint = Color.White
                        )
                    },
                    label = {
                        /*
                        Text(
                            text = "",//list.category.name,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                         */
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = AssistChipDefaults.assistChipColors(disabledContainerColor = list.category.color)
                )
            }
            Text(
                text = list.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListItem_Preview() {
    ShoppingListItem(
        list = ShoppingList(
            id = 1,
            name = "Liste",
            description = "",
            category = ShoppingListCategory.BlueCategory,
            createdTimestamp = System.currentTimeMillis(),
            listElements = emptyList()
        ),
        modifier = Modifier.width(200.dp)
    )
}