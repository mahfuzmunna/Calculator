package com.mahfuzmunna.calculator.ui.screens



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahfuzmunna.calculator.ui.components.Display
import com.mahfuzmunna.calculator.ui.components.MiniDisplay

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {
    val display by viewModel.displayText
    val results by viewModel.resultsOut
    Column {
        Display(display)
        MiniDisplay(results)
        Spacer(modifier = Modifier.height(16.dp))

        CalculatorButtons(onClick = viewModel::onButtonClick)
//        CalculatorButtons(onButtonClick = viewModel::onButtonClick)
    }

}
