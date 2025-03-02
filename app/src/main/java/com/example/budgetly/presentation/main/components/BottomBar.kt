package com.example.budgetly.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.budgetly.R
import com.example.budgetly.navigation.NavigationBottomItem

@Composable
fun BottomBar(itemSelected: Int, onItemSelected: (Int) -> Unit, navController: NavHostController) {
    BottomAppBar(containerColor = MaterialTheme.colorScheme.surfaceContainer) {
        //Expense
        BottomNavigationItem(
            selected = itemSelected == 0,
            onClick = {
                navController.navigate(NavigationBottomItem.Expense.route)
                onItemSelected(0)
            },
            icon = {
                IconBottomNavigationItem(
                    painterResource(R.drawable.ic_receipt_filled),
                    painterResource(R.drawable.ic_receipt_outline),
                    "expense icon",
                    itemSelected == 0
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.expense_title),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        )

        //Home
        BottomNavigationItem(
            selected = itemSelected == 1,
            onClick = {
                navController.navigate(NavigationBottomItem.Home.route)
                onItemSelected(1)
            },
            icon = {
                IconBottomNavigationItem(
                    painterResource(R.drawable.ic_home_filled),
                    painterResource(R.drawable.ic_home_outlined),
                    "home icon",
                    itemSelected == 1
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.home_title),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelSmall,
                )
            },
            selectedContentColor = MaterialTheme.colorScheme.primary,
        )

        //User
        BottomNavigationItem(
            selected = itemSelected == 2,
            onClick = {
                navController.navigate(NavigationBottomItem.User.route)
                onItemSelected(2)
            },
            icon = {
                IconBottomNavigationItem(
                    painterResource(R.drawable.ic_person_filled),
                    painterResource(R.drawable.ic_person_outlined),
                    "person icon",
                    itemSelected == 2
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.person_title),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        )
    }
}

@Composable
fun IconBottomNavigationItem(
    iconFilled: Painter,
    iconOutlined: Painter,
    contentDescription: String,
    itemSelected: Boolean
) {
    var icon = iconOutlined
    var colorContainer = MaterialTheme.colorScheme.surfaceContainer

    if (itemSelected) {
        icon = iconFilled
        colorContainer = MaterialTheme.colorScheme.secondaryContainer
    }

    Box(
        modifier = Modifier
            .background(
                color = colorContainer,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(horizontal = 12.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}