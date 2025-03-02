package com.example.budgetly.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.budgetly.R

@Composable
fun CustomPasswordTextField(text: String, value: String, onChanged: (String) -> Unit) {
    var showPassword by remember { mutableStateOf(false) }
    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
        value = value,
        singleLine = true,
        onValueChange = { onChanged(it) },
        label = {
            Text(text = text)
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                showPassword = !showPassword
            }) {
                Icon(
                    painter = if (showPassword) painterResource(R.drawable.ic_visibility) else painterResource(
                        R.drawable.ic_visibility_off
                    ),
                    contentDescription = ""
                )
            }
        })
}