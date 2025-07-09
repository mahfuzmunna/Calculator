package com.mahfuzmunna.calculator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahfuzmunna.calculator.ui.components.CalculatorButtonItem

enum class ButtonType {
    NUMBER,
    OPERATOR,
    ACTION
}

enum class CalculatorButton(val label: String, val type: ButtonType) {

    // Numbers
    Zero("0", ButtonType.NUMBER),
    One("1", ButtonType.NUMBER),
    Two("2", ButtonType.NUMBER),
    Three("3", ButtonType.NUMBER),
    Four("4", ButtonType.NUMBER),
    Five("5", ButtonType.NUMBER),
    Six("6", ButtonType.NUMBER),
    Seven("7", ButtonType.NUMBER),
    Eight("8", ButtonType.NUMBER),
    Nine("9", ButtonType.NUMBER),
    Dot(".", ButtonType.NUMBER),

    // Operators
    Add("+", ButtonType.OPERATOR),
    Subtract("-", ButtonType.OPERATOR),
    Multiply("×", ButtonType.OPERATOR),
    Divide("÷", ButtonType.OPERATOR),
    Parentheses_Open("(", ButtonType.OPERATOR),
    Parentheses_Close(")", ButtonType.OPERATOR),
    Percentage("%", ButtonType.OPERATOR),

    // Actions
    Clear("C", ButtonType.ACTION),
    Delete("⌫", ButtonType.ACTION),
    Equals("=", ButtonType.ACTION);
}
@Composable
fun CalculatorButtons(
    onClick: (CalculatorButton) -> Unit
) {
    val buttons = listOf(
        listOf(CalculatorButton.Clear, CalculatorButton.Delete, CalculatorButton.Divide, CalculatorButton.Multiply),
        listOf(CalculatorButton.Seven, CalculatorButton.Eight, CalculatorButton.Nine, CalculatorButton.Subtract),
        listOf(CalculatorButton.Four, CalculatorButton.Five, CalculatorButton.Six, CalculatorButton.Add),
        listOf(CalculatorButton.One, CalculatorButton.Two, CalculatorButton.Three, CalculatorButton.Equals),
        listOf(CalculatorButton.Zero, CalculatorButton.Dot, CalculatorButton.Parentheses_Open, CalculatorButton.Parentheses_Close)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                row.forEach { button ->
                    CalculatorButtonItem(
                        button = button,
                        modifier = Modifier
                            .weight(
                                if (button == CalculatorButton.Zero && row.size == 2) 2f else 1f
                            )
                            .aspectRatio(1f),
                        onClick = onClick
                    )
                }
            }
        }
    }
}


