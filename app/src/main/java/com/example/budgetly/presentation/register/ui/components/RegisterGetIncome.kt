package com.example.budgetly.presentation.register.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.chargemap.compose.numberpicker.ListItemPicker
import com.example.budgetly.R
import com.example.budgetly.presentation.register.viewModel.RegisterViewModel

@Composable
fun RegisterGetIncome(
    incomeConcurrent: String?,
    registerViewModel: RegisterViewModel
) {
    val incomeConcurrentList = listOf(
        stringResource(R.string.weekly_register),
        stringResource(R.string.biweekly_register),
        stringResource(R.string.monthly_register)
    )

    LaunchedEffect(Unit) {
        if (incomeConcurrent == null) {
            registerViewModel.onChangeIncomeConcurrent(incomeConcurrentList[0])
        }
    }

    ListItemPicker(
        label = { it },
        dividersColor = MaterialTheme.colorScheme.primary,
        textStyle = MaterialTheme.typography.labelLarge,
        value = incomeConcurrent ?: incomeConcurrentList[1],
        onValueChange = { registerViewModel.onChangeIncomeConcurrent(it) },
        list = incomeConcurrentList
    )
}