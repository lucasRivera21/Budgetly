package com.example.budgetly.navigation

sealed class NavigationBottomItem(val route: String) {
    data object Expense : NavigationBottomItem("expense_screen")
    data object Home : NavigationBottomItem("home_screen")
    data object User : NavigationBottomItem("user_screen")

}