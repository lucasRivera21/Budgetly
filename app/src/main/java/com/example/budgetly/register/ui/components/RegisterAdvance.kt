package com.example.budgetly.register.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun RegisterAdvance(step: Int, numberOfSteps: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..numberOfSteps) {
            if (i != 1) {
                Spacer(Modifier.size(16.dp))
            }
            Box(
                modifier = Modifier
                    .width((240 / numberOfSteps).dp)
                    .height(8.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(if (i > step) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.primary)
            )
        }
    }
}