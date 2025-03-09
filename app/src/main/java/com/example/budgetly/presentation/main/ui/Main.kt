package com.example.budgetly.presentation.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.budgetly.navigation.BottomNavigation
import com.example.budgetly.presentation.main.components.BottomBar
import com.example.budgetly.ui.theme.AppTheme

@Composable
fun Main() {
    val bottomNavController = rememberNavController()
    var itemSelected by remember { mutableIntStateOf(1) }

    Scaffold(bottomBar = {
        BottomBar(itemSelected, { itemSelected = it }, bottomNavController)
    }) { _ ->
        Box {
            BottomNavigation(bottomNavController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainPreview() {
    AppTheme {
        Main()
    }
}