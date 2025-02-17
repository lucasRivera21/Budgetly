package com.example.budgetly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.budgetly.home.Home
import com.example.budgetly.login.ui.LoginScreen
import com.example.budgetly.register.ui.RegisterScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(innerPadding: PaddingValues, navController: NavHostController, auth: FirebaseAuth) {

    val modifier = Modifier.padding(innerPadding)

    NavHost(navController = navController, startDestination = NavigationItem.Login.route) {
        composable(NavigationItem.Login.route) {
            LoginScreen(modifier, navController, auth)
        }

        composable(NavigationItem.Register.route) {
            RegisterScreen(modifier, navController, auth)
        }

        composable(NavigationItem.Home.route) {
            Home()
        }
    }
}