package com.mahfuzmunna.calculator.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _displayText = mutableStateOf("0")
    private val _resultsText = mutableStateOf("")
    val displayText: State<String> = _displayText
    val resultsOut: State<String> = _resultsText

    fun onButtonClick(button: CalculatorButton) {
        when (button) {
            CalculatorButton.Clear -> {
                _displayText.value = "0"
                _resultsText.value = ""
            }
            CalculatorButton.Equals -> _resultsText.value = evaluate(_displayText.value)
            CalculatorButton.Delete -> _displayText.value =
                _displayText.value.dropLast(1).ifEmpty { "0" }
            else -> {
                if (_displayText.value == "0") {
                    _displayText.value = button.label
                } else {
                    _displayText.value += button.label
                }
            }
        }
    }

    fun evaluate(expression: String): String {
        return try {
            val parser = ExpressionParser(expression)
            val result = parser.parse()
            if (result % 1 == 0.0) result.toInt().toString() else result.toString()
        } catch (e: Exception) {
            "Error"
        }
    }

}

private class ExpressionParser(expr: String) {
    private val tokens: List<String>
    private var index = 0

    init {
        tokens = tokenize(expr.replace("×", "*").replace("÷", "/"))
    }

    fun parse(): Double {
        val result = parseExpression()
        if (index != tokens.size) throw IllegalArgumentException("Unexpected token")
        return result
    }

    private fun parseExpression(): Double {
        var result = parseTerm()
        while (index < tokens.size) {
            val op = tokens[index]
            if (op == "+" || op == "-") {
                index++
                val right = parseTerm()
                result = if (op == "+") result + right else result - right
            } else break
        }
        return result
    }

    private fun parseTerm(): Double {
        var result = parseFactor()
        while (index < tokens.size) {
            val op = tokens[index]
            if (op == "*" || op == "/") {
                index++
                val right = parseFactor()
                result = if (op == "*") result * right else result / right
            } else break
        }
        return result
    }

    private fun parseFactor(): Double {
        val token = tokens[index]
        return when {
            token == "(" -> {
                index++
                val result = parseExpression()
                if (tokens.getOrNull(index) != ")") throw IllegalArgumentException("Missing )")
                index++
                result
            }
            token == "-" -> {
                index++
                -parseFactor()
            }
            else -> {
                index++
                token.toDoubleOrNull() ?: throw IllegalArgumentException("Invalid number: $token")
            }
        }
    }

    private fun tokenize(expr: String): List<String> {
        val tokens = mutableListOf<String>()
        var i = 0
        while (i < expr.length) {
            val c = expr[i]
            when {
                c.isDigit() || c == '.' -> {
                    val start = i
                    while (i < expr.length && (expr[i].isDigit() || expr[i] == '.')) i++
                    tokens.add(expr.substring(start, i))
                    continue
                }
                c in "+-*/()" -> tokens.add(c.toString())
            }
            i++
        }
        return tokens
    }
}
