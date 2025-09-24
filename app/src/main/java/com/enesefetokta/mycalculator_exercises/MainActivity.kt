package com.enesefetokta.mycalculator_exercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enesefetokta.mycalculator_exercises.ui.theme.MyCalculatorExercisesTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCalculatorExercisesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var displayText by remember { mutableStateOf("") }

    val onButtonClick: (String) -> Unit = { buttonText ->
        when (buttonText) {
            "C" -> {
                displayText = "0"
            }

            else -> {
                if (displayText == "0") {
                    displayText = buttonText
                } else {
                    displayText += buttonText
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = displayText,
                style = MaterialTheme.typography.displayLarge,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(text = "AC", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "C", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "/", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "X", modifier = Modifier.weight(1f), onClick = onButtonClick)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(text = "7", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "8", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "9", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "-", modifier = Modifier.weight(1f), onClick = onButtonClick)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(text = "4", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "5", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "6", modifier = Modifier.weight(1f), onClick = onButtonClick)
                CalculatorButton(text = "+", modifier = Modifier.weight(1f), onClick = onButtonClick)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier.weight(3f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CalculatorButton(text = "1", modifier = Modifier.weight(1f), onClick = onButtonClick)
                        CalculatorButton(text = "2", modifier = Modifier.weight(1f), onClick = onButtonClick)
                        CalculatorButton(text = "3", modifier = Modifier.weight(1f), onClick = onButtonClick)
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CalculatorButton(
                            text = "0",
                            modifier = Modifier.weight(2f)
                        )
                        CalculatorButton(text = ".", modifier = Modifier.weight(1f), onClick = onButtonClick)
                    }
                }

                CalculatorButton(
                    text = "=",
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    onClick = onButtonClick
                )
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    Button(
        onClick = { onClick(text) },
        modifier = modifier.height(80.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    MyCalculatorExercisesTheme {
        CalculatorApp()
    }
}