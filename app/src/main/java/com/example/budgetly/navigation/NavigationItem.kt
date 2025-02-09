package com.example.budgetly.navigation

sealed class NavigationItem(val route: String) {
    data object Login : NavigationItem("login_screen")
    data object RegisterAboutYou : NavigationItem("register_about_you_screen")
    data object Home : NavigationItem("home_screen")
}