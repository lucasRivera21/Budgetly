package com.example.budgetly.presentation.register.models

data class User(
    val uid: String? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthday: String? = null,
    val income: String? = null,
    val moneyType: String? = null,
    val incomeConcurrent: String? = null
)
