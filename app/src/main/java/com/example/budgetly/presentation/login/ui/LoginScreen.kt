package com.example.budgetly.presentation.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.budgetly.R
import com.example.budgetly.presentation.login.viewModel.LoginViewModel
import com.example.budgetly.navigation.NavigationItem
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(
    modifier: Modifier,
    navController: NavController,
    auth: FirebaseAuth,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val email by loginViewModel.email.observeAsState("")
    val password by loginViewModel.password.observeAsState("")
    val isVisible by loginViewModel.isVisible.observeAsState(false)
    val isLoading by loginViewModel.isLoading.observeAsState(false)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()

        ContainerOutlineInput(
            loginViewModel,
            email,
            password,
            isVisible,
            auth,
            navController,
            isLoading
        )

        ContainerSettingAccount(navController)

        Footer()
    }
}

@Composable
fun Header() {
    Text(
        text = stringResource(R.string.title_login),
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun ContainerOutlineInput(
    loginViewModel: LoginViewModel,
    email: String,
    password: String,
    isVisible: Boolean,
    auth: FirebaseAuth,
    navController: NavController,
    isLoading: Boolean
) {
    val inputsText = stringResource(R.string.validate_inputs_empty)
    Column {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = email,
            singleLine = true,
            onValueChange = { loginViewModel.onChangeEmail(it) },
            label = {
                Text(stringResource(R.string.email_login))
            })

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { loginViewModel.onChangePassword(it) },
            singleLine = true,
            visualTransformation = if (!isVisible) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                Icon(
                    painter = if (!isVisible) painterResource(R.drawable.ic_visibility_off) else painterResource(
                        R.drawable.ic_visibility
                    ),
                    "icon visibility",
                    modifier = Modifier.clickable { loginViewModel.changeVisibility() },
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },
            label = {
                Text(stringResource(R.string.password_login))
            })

        Spacer(Modifier.size(32.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { loginViewModel.verifyEmptyInputs(auth, inputsText, navController) }) {
            if (!isLoading) {
                Text(stringResource(R.string.button_text_login), fontSize = 14.sp)
            } else {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun ContainerSettingAccount(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Text(
                stringResource(R.string.new_user_login),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.size(4.dp))
            Text(
                stringResource(R.string.register_login),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelLarge,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController.navigate(NavigationItem.Register.route)
                }
            )
        }

        Spacer(Modifier.size(8.dp))

        Text(
            stringResource(R.string.forget_password_login),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { }
        )
    }
}

@Composable
fun Footer() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            stringResource(R.string.footer_login),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(Modifier.size(4.dp))
        Text(
            stringResource(R.string.terms_login),
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.clickable { }
        )
    }
}