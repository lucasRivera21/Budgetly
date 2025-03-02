package com.example.budgetly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.budgetly.presentation.expense.ui.ExpenseScreen
import com.example.budgetly.presentation.home.ui.HomeScreen
import com.example.budgetly.presentation.user.ui.UserScreen

@Composable
fun BottomNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationBottomItem.Home.route
    ) {
        composable(NavigationBottomItem.Expense.route) {
            ExpenseScreen()
        }

        composable(NavigationBottomItem.Home.route) {
            HomeScreen()
        }

        composable(NavigationBottomItem.User.route) {
            UserScreen()
        }

    }
}