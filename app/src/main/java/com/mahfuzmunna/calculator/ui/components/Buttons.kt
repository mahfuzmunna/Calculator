package com.mahfuzmunna.calculator.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahfuzmunna.calculator.ui.screens.ButtonType
import com.mahfuzmunna.calculator.ui.screens.CalculatorButton

@Composable
fun CalculatorButtonItem(
    button: CalculatorButton,
    modifier: Modifier = Modifier,
    onClick: (CalculatorButton) -> Unit
) {
    val backgroundColor = when (button.type) {
        ButtonType.NUMBER -> Color.DarkGray
        ButtonType.OPERATOR -> Color(0xFFFF9800)
        ButtonType.ACTION -> Color.Gray
    }

    Button(
        onClick = { onClick(button) },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.White
        ),
        modifier = modifier
            .padding(4.dp)
    ) {
        Text(
            text = button.label,
            fontSize = 28.sp
        )
    }
}
