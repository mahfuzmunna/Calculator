package com.mahfuzmunna.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahfuzmunna.calculator.ui.screens.CalculatorScreen
import com.mahfuzmunna.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Calculator") },
//                            navigationIcon = {
//                                IconButton(onClick = {}) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Menu,
//                                        contentDescription = "",
//                                    )
//                                }
//                            },
//                TO BE IMPLEMENTED LATER
//                FEATURE TO BE ADDED : USER PROFILE MECHANISM
//                            actions = {
//                                if (false) IconButton(
//                                    modifier = Modifier,
//                                    onClick = {}) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Person,
//                                        contentDescription = "",
//                                    )
//                                }
//                            }
                        )
                    }) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        CalculatorScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Greeting("Android")
    }
}