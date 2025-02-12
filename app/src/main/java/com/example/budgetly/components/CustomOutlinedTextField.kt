package com.example.budgetly.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomOutlinedTextField(text: String, value: String, onChanged: (String) -> Unit) {
    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
        value = value,
        singleLine = true,
        onValueChange = { onChanged(it) },
        label = {
            Text(text = text)
        })
}