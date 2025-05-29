package com.example.zadanie2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zadanie2.ui.theme.Zadanie2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zadanie2Theme {
                CounterExample()
            }
        }
    }
}

@Composable
fun CounterExample() {
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("N/A") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = firstNumber,
            onValueChange = { firstNumber = it },
            label = { Text("Enter first number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        TextField(
            value = secondNumber,
            onValueChange = { secondNumber = it },
            label = { Text("Enter second number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier.weight(1f).padding(end = 4.dp),
                shape = RectangleShape,
                onClick = {
                    val num1 = firstNumber.toIntOrNull()
                    val num2 = secondNumber.toIntOrNull()
                    result = if (num1 != null && num2 != null) {
                        (num1 + num2).toString()
                    } else {
                        "Invalid input"
                    }
                }
            ) {
                Text(text = "+")
            }

            Button(
                modifier = Modifier.weight(1f).padding(end = 4.dp),
                shape = RectangleShape,
                onClick = {
                    val num1 = firstNumber.toIntOrNull()
                    val num2 = secondNumber.toIntOrNull()
                    result = if (num1 != null && num2 != null) {
                        (num1 - num2).toString()
                    } else {
                        "Invalid input"
                    }
                }
            ) {
                Text(text = "-")
            }

            Button(
                modifier = Modifier.weight(1f).padding(end = 4.dp),
                shape = RectangleShape,
                onClick = {
                    val num1 = firstNumber.toIntOrNull()
                    val num2 = secondNumber.toIntOrNull()
                    result = if (num1 != null && num2 != null) {
                        (num1 * num2).toString()
                    } else {
                        "Invalid input"
                    }
                }
            ) {
                Text(text = "×")
            }

            Button(
                modifier = Modifier.weight(1f),
                shape = RectangleShape,
                onClick = {
                    val num1 = firstNumber.toIntOrNull()
                    val num2 = secondNumber.toIntOrNull()
                    result = if (num1 != null && num2 != null) {
                        if (num2 == 0) "Division by zero" else (num1 / num2).toString()
                    } else {
                        "Invalid input"
                    }
                }
            ) {
                Text(text = "÷")
            }
        }

        Text(
            text = "Result: $result",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
