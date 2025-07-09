package com.mahfuzmunna.calculator.ui.components

import android.view.Display
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Display(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text(
            text = text,
            fontSize = 48.sp,
            color = Color.Gray,
            textAlign = TextAlign.End,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
