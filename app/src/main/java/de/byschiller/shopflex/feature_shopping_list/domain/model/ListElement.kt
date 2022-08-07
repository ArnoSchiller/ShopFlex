package de.byschiller.shopflex.feature_shopping_list.domain.model

data class ListElement(
    val name: String,
    val details: String,
    val createdTimestamp: Long
)