package com.example.budgetly.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomNumberTextField(text: String, value: String, onChangeValue: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        singleLine = true,
        onValueChange = { onChangeValue(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            Text(text = text)
        })
}