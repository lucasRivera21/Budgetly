package com.example.budgetly.data

sealed class CollectionItem(val collectionName: String) {
    data object Users : CollectionItem("users")
}