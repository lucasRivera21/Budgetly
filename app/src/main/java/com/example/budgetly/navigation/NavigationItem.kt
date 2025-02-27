package com.example.budgetly.navigation

sealed class NavigationItem(val route: String) {
    data object Splash : NavigationItem("splash_screen")
    data object Login : NavigationItem("login_screen")
    data object Register : NavigationItem("register_screen")
    data object Home : NavigationItem("home_screen")
}