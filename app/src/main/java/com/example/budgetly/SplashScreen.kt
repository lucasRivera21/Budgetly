package com.example.budgetly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.budgetly.navigation.NavigationItem
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SplashScreen(navController: NavHostController, auth: FirebaseAuth) {
    LaunchedEffect(auth.currentUser) {
        if (auth.currentUser != null) {
            navController.navigate(NavigationItem.Home.route)
        }else{
            navController.navigate(NavigationItem.Login.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {

    }
}