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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.budgetly.Credentials.Companion.NUMBER_OF_STEPS
import com.example.budgetly.R
import com.example.budgetly.components.CustomButton
import com.example.budgetly.register.ui.components.AboutAccountRegister
import com.example.budgetly.register.ui.components.AboutIncomeRegister
import com.example.budgetly.register.ui.components.AboutUserRegister
import com.example.budgetly.register.ui.components.RegisterAdvance
import com.example.budgetly.register.viewModel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun RegisterScreen(
    modifier: Modifier,
    navController: NavController,
    auth: FirebaseAuth,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
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

    val textInputsEmpty = stringResource(R.string.validate_inputs_empty)
    val textPasswordsDiff = stringResource(R.string.validate_passwords_diff)

    LaunchedEffect(Unit) {
        registerViewModel.getCurrentYear()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Header(navController, registerViewModel)

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

        Footer(step, textInputsEmpty, textPasswordsDiff, navController, auth, registerViewModel)
    }
}

@Composable
fun Header(navController: NavController, registerViewModel: RegisterViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { registerViewModel.onBackStep(navController) }) {
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
                2 -> stringResource(R.string.about_income_register)
                else -> stringResource(R.string.about_account_register)
            },
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.size(64.dp))

        when (step) {
            1 -> {
                AboutUserRegister(
                    name = name,
                    lastName = lastName,
                    dayValue = dayValue,
                    monthValue = monthValue,
                    yearValue = yearValue,
                )
            }

            2 -> {
                AboutIncomeRegister(
                    incomeValue = incomeValue,
                    moneyType = moneyType,
                    incomeConcurrent = incomeConcurrent,
                )
            }

            3 -> {
                AboutAccountRegister(
                    email = email,
                    password = password,
                    repeatPassword = repeatPassword,
                )
            }
        }


    }
}

@Composable
fun Footer(
    step: Int,
    textInputsEmpty: String,
    textPasswordsDiff: String,
    navController: NavController,
    auth: FirebaseAuth,
    registerViewModel: RegisterViewModel
) {
    Column {
        RegisterAdvance(step, NUMBER_OF_STEPS)

        Spacer(Modifier.size(24.dp))

        CustomButton(if (step == 3) stringResource(R.string.register_register) else stringResource(R.string.next_register)) {
            registerViewModel.onValidateInputs(
                textInputsEmpty,
                textPasswordsDiff,
                navController,
                auth
            )
        }
    }

}