package com.example.budgetly.register.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.budgetly.R
import com.example.budgetly.components.CustomOutlinedTextField
import com.example.budgetly.components.CustomPasswordTextField
import com.example.budgetly.register.viewModel.RegisterViewModel

@Composable
fun AboutAccountRegister(
    email: String,
    password: String,
    repeatPassword: String,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    CustomOutlinedTextField(stringResource(R.string.email_register), email) {
        registerViewModel.onChangeEmail(it)
    }

    Spacer(Modifier.size(16.dp))

    CustomPasswordTextField(stringResource(R.string.password_register), password) {
        registerViewModel.onChangePassword(it)
    }

    Spacer(Modifier.size(16.dp))

    CustomPasswordTextField(stringResource(R.string.repeat_password_register), repeatPassword) {
        registerViewModel.onChangeRepeatPassword(it)
    }
}