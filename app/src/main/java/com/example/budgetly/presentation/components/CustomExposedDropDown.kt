package com.example.budgetly.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.budgetly.presentation.register.viewModel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomExposedDropDown(moneyTypeSelected: String, registerViewModel: RegisterViewModel) {
    val moneyTypeList = listOf("USD", "COP", "EUR")
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
                .menuAnchor()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = moneyTypeSelected, style = MaterialTheme.typography.labelLarge)
                Spacer(Modifier.size(4.dp))
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "open menu"
                )
            }
        }

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            moneyTypeList.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        //moneyTypeSelected = option
                        registerViewModel.onChangeMoneyType(option)
                        expanded = false
                    }
                )
            }
        }
    }
}