package com.example.budgetly.login.ui

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgetly.R

@Composable
fun LoginScreen(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()

        ContainerOutlineInput(email, { email = it }, password, { password = it })

        ContainerSettingAccount()

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
    email: String,
    onChangeEmail: (String) -> Unit,
    password: String,
    onChangePassword: (String) -> Unit
) {
    Column {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { onChangeEmail(it) },
            label = {
                Text(stringResource(R.string.email_login))
            })

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { onChangePassword(it) },
            label = {
                Text(stringResource(R.string.password_login))
            })

        Spacer(Modifier.size(32.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
            Text(stringResource(R.string.button_text_login), fontSize = 14.sp)
        }
    }
}

@Composable
fun ContainerSettingAccount() {
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
                modifier = Modifier.clickable { }
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

/*@Preview(showSystemUi = true)
@Composable
fun TestLoginScreen() {
    AppTheme {
        LoginScreen(Modifier.padding(30.dp))
    }
}*/