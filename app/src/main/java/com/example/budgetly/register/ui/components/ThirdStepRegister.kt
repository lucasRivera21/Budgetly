package com.example.budgetly.register.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.budgetly.R
import com.example.budgetly.components.CustomExposedDropDown
import com.example.budgetly.components.CustomNumberTextField
import com.example.budgetly.register.viewModel.RegisterViewModel

@Composable
fun ThirdStepRegister(
    incomeValue: String,
    moneyType: String,
    incomeConcurrent: String?,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CustomNumberTextField(stringResource(R.string.income_monthly_register), incomeValue) {
            registerViewModel.onChangeIncomeValue(it)
        }
        CustomExposedDropDown(moneyType, registerViewModel)
    }

    Spacer(Modifier.size(16.dp))

    Text(
        stringResource(R.string.get_income_register),
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.bodyLarge
    )

    Spacer(Modifier.size(16.dp))

    RegisterGetIncome(incomeConcurrent, registerViewModel)
}