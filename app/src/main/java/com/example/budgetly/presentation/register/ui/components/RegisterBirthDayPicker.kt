package com.example.budgetly.presentation.register.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.chargemap.compose.numberpicker.ListItemPicker
import com.chargemap.compose.numberpicker.NumberPicker
import com.example.budgetly.R
import com.example.budgetly.presentation.register.viewModel.RegisterViewModel

@Composable
fun RegisterBirthDayPicker(
    dayValue: Int,
    monthValue: String?,
    yearValue: Int?,
    registerViewModel: RegisterViewModel
) {
    val monthList = listOf(
        stringResource(R.string.month_1_register),
        stringResource(R.string.month_2_register),
        stringResource(R.string.month_3_register),
        stringResource(R.string.month_4_register),
        stringResource(R.string.month_5_register),
        stringResource(R.string.month_6_register),
        stringResource(R.string.month_7_register),
        stringResource(R.string.month_8_register),
        stringResource(R.string.month_9_register),
        stringResource(R.string.month_10_register),
        stringResource(R.string.month_11_register),
        stringResource(R.string.month_12_register)
    )

    LaunchedEffect(Unit) {
        if (monthValue == null) {
            registerViewModel.onChangeMonthValue(monthList[0])
        }
    }

    Row {
        ListItemPicker(
            label = { it },
            dividersColor = MaterialTheme.colorScheme.primary,
            textStyle = MaterialTheme.typography.labelLarge,
            value = monthValue ?: monthList[0],
            onValueChange = { registerViewModel.onChangeMonthValue(it) },
            list = monthList
        )

        NumberPicker(value = dayValue,
            dividersColor = MaterialTheme.colorScheme.primary,
            textStyle = MaterialTheme.typography.labelLarge,
            range = registerViewModel.getNumberDayDependsMonth(monthList),
            onValueChange = {
                registerViewModel.onChangeDayValue(it)
            })

        NumberPicker(value = yearValue ?: 2000,
            dividersColor = MaterialTheme.colorScheme.primary,
            textStyle = MaterialTheme.typography.labelLarge,
            range = 2025 downTo 1900,
            onValueChange = {
                registerViewModel.onChangeYearValue(it)
            })
    }

}