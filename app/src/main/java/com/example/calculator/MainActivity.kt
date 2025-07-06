package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    var expression by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun onButtonClick(symbol: String) {
        when (symbol) {
            "=" -> {
                try {
                    val evaluated = evaluateExpression(expression)
                    result = evaluated
                } catch (e: Exception) {
                    result = "Error"
                }
            }
            "C" -> {
                expression = ""
                result = ""
            }
            else -> {
                expression += symbol
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(text = expression, color = Color.White, fontSize = 32.sp)
            Text(text = result, color = Color.Green, fontSize = 24.sp)
        }

        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", "C", "=", "+")
        )

        for (row in buttons) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (symbol in row) {
                    CalculatorButton(symbol, onClick = { onButtonClick(symbol) })
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(symbol: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.DarkGray)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

fun evaluateExpression(expr: String): String {
    return try {
        val result = ExpressionParser().evaluate(expr)
        if (result % 1.0 == 0.0) {
            result.toInt().toString()
        } else {
            (round(result * 1000) / 1000.0).toString()
        }
    } catch (e: Exception) {
        "Error"
    }
}

class ExpressionParser {
    fun evaluate(expression: String): Double {
        val cleanedExpr = expression.replace("×", "*").replace("÷", "/")
        val tokens = Regex("[+\\-*/]").split(cleanedExpr).map { it.trim() }
        val ops = Regex("[+\\-*/]").findAll(cleanedExpr).map { it.value }.toList()

        if (tokens.isEmpty()) return 0.0

        var result = tokens[0].toDoubleOrNull() ?: return 0.0

        for (i in ops.indices) {
            val num = tokens.getOrNull(i + 1)?.toDoubleOrNull() ?: continue
            when (ops[i]) {
                "+" -> result += num
                "-" -> result -= num
                "*" -> result *= num
                "/" -> result /= num
            }
        }
        return result
    }
}
