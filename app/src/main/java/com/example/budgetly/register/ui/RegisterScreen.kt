package com.example.budgetly.register.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.budgetly.Credentials.Companion.NUMBER_OF_STEPS
import com.example.budgetly.R
import com.example.budgetly.components.CustomButton
import com.example.budgetly.components.CustomOutlinedTextField
import com.example.budgetly.register.ui.components.RegisterAdvance
import com.example.budgetly.register.ui.components.RegisterBirthDayPicker
import com.example.budgetly.register.viewModel.RegisterViewModel
import com.example.budgetly.ui.theme.AppTheme

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = hiltViewModel()) {
    val step by registerViewModel.step.observeAsState(1)

    val name by registerViewModel.name.observeAsState("")
    val lastName by registerViewModel.lastName.observeAsState("")

    val dayValue by registerViewModel.dayValue.observeAsState(1)
    val monthValue by registerViewModel.monthValue.observeAsState()
    val yearValue by registerViewModel.yearValue.observeAsState()

    LaunchedEffect(Unit) {
        registerViewModel.getCurrentYear()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Header()

        InputsBody(name, lastName, dayValue, monthValue, yearValue, registerViewModel)

        Footer(step)
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "arrow-back",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.title_register),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
fun InputsBody(
    name: String,
    lastName: String,
    dayValue: Int,
    monthValue: String?,
    yearValue: Int?,
    registerViewModel: RegisterViewModel,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.about_you_register),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.size(64.dp))

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
}

@Composable
fun Footer(step: Int) {
    Column {
        RegisterAdvance(step, NUMBER_OF_STEPS)

        Spacer(Modifier.size(24.dp))

        CustomButton(stringResource(R.string.next_register)) { }
    }

}

@Preview(showSystemUi = true)
@Composable
fun TestingRegister() {
    AppTheme {
        RegisterScreen()
    }
}