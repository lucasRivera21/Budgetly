package com.example.budgetly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgetly.login.ui.LoginScreen
import com.example.budgetly.register.ui.RegisterScreen

@Composable
fun AppNavigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    val modifier = Modifier.padding(innerPadding)

    NavHost(navController = navController, startDestination = NavigationItem.Login.route) {
        composable(NavigationItem.Login.route) {
            LoginScreen(modifier, navController)
        }

        composable(NavigationItem.Register.route) {
            RegisterScreen(navController)
        }
    }
}