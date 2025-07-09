package com.mahfuzmunna.calculator.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _displayText = mutableStateOf("0")
    val displayText: State<String> = _displayText
    val resultsOut: State<String> = _displayText

    fun onButtonClick(button: CalculatorButton) {
        when (button) {
            CalculatorButton.Clear -> _displayText.value = "0"
//            CalculatorButton.Equals -> evaluate()
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
}