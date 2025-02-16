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
import com.example.budgetly.register.ui.components.FirstStepRegister
import com.example.budgetly.register.ui.components.RegisterAdvance
import com.example.budgetly.register.ui.components.SecondStepRegister
import com.example.budgetly.register.ui.components.ThirdStepRegister
import com.example.budgetly.register.viewModel.RegisterViewModel
import com.example.budgetly.ui.theme.AppTheme

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = hiltViewModel()) {
    val step by registerViewModel.step.observeAsState(1)

    //First Step
    val name by registerViewModel.name.observeAsState("")
    val lastName by registerViewModel.lastName.observeAsState("")
    val dayValue by registerViewModel.dayValue.observeAsState(1)
    val monthValue by registerViewModel.monthValue.observeAsState()
    val yearValue by registerViewModel.yearValue.observeAsState()

    //Second Step
    val email by registerViewModel.email.observeAsState("")
    val password by registerViewModel.password.observeAsState("")
    val repeatPassword by registerViewModel.repeatPassword.observeAsState("")

    //Third Step
    val incomeValue by registerViewModel.incomeValue.observeAsState("")
    val moneyType by registerViewModel.moneyType.observeAsState("USD")
    val incomeConcurrent by registerViewModel.incomeConcurrent.observeAsState()

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

        Header(registerViewModel)

        InputsBody(
            name,
            lastName,
            dayValue,
            monthValue,
            yearValue,
            email,
            password,
            repeatPassword,
            incomeValue,
            moneyType,
            incomeConcurrent,
            step
        )

        Footer(step, registerViewModel)
    }
}

@Composable
fun Header(registerViewModel: RegisterViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { registerViewModel.onBackStep() }) {
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
    email: String,
    password: String,
    repeatPassword: String,
    incomeValue: String,
    moneyType: String,
    incomeConcurrent: String?,
    step: Int
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = when (step) {
                1 -> stringResource(R.string.about_you_register)
                2 -> stringResource(R.string.about_account_register)
                else -> stringResource(R.string.about_income_register)
            },
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.size(64.dp))

        when (step) {
            1 -> {
                FirstStepRegister(
                    name = name,
                    lastName = lastName,
                    dayValue = dayValue,
                    monthValue = monthValue,
                    yearValue = yearValue,
                )
            }

            2 -> {
                SecondStepRegister(
                    email = email,
                    password = password,
                    repeatPassword = repeatPassword,
                )
            }

            3 -> {
                ThirdStepRegister(
                    incomeValue = incomeValue,
                    moneyType = moneyType,
                    incomeConcurrent = incomeConcurrent,
                )
            }
        }


    }
}

@Composable
fun Footer(step: Int, registerViewModel: RegisterViewModel) {
    Column {
        RegisterAdvance(step, NUMBER_OF_STEPS)

        Spacer(Modifier.size(24.dp))

        CustomButton(if (step == 3) stringResource(R.string.register_register) else stringResource(R.string.next_register)) {
            registerViewModel.onNextStep()
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun TestingRegister() {
    AppTheme {
        RegisterScreen()
    }
}