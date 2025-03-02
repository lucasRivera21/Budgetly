package com.example.budgetly.presentation.register.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.budgetly.R
import com.example.budgetly.presentation.components.CustomOutlinedTextField
import com.example.budgetly.presentation.register.viewModel.RegisterViewModel

@Composable
fun AboutUserRegister(
    name: String,
    lastName: String,
    dayValue: Int,
    monthValue: String?,
    yearValue: Int?,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    CustomOutlinedTextField(stringResource(R.string.name_register), name) {
        registerViewModel.onChangeName(it)
    }

    Spacer(Modifier.size(16.dp))

    CustomOutlinedTextField(stringResource(R.string.last_name_register), lastName) {
        registerViewModel.onChangeLastName(it)
    }

    Spacer(Modifier.size(16.dp))

    Text(
        text = stringResource(R.string.birthday_register),
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.bodyLarge
    )

    Spacer(Modifier.size(8.dp))

    RegisterBirthDayPicker(dayValue, monthValue, yearValue, registerViewModel)
}