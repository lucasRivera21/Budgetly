package com.example.budgetly.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CustomButton(
    text: String,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    onClicked: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onClicked() },
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = textColor,
            disabledContentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Text(text, style = MaterialTheme.typography.bodyMedium)
    }
}