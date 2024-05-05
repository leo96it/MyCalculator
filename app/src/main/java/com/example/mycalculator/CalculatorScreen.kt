import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycalculator.ui.theme.MyCalculatorTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import java.lang.Exception


@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel() // questo viene da androidx.lifecycle.viewmodel.compose.viewModel
)

{
    //var number by rememberSaveable { mutableStateOf("") }

    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End)
    {
        ResultDisplay(
            result = uiState.currentValue,
            operation = uiState.operation,
            modifier = modifier)
        Divider(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        CalcKeyboard(modifier = modifier,
            onValueClick = { viewModel.numberAppend(number = it) },
            onOperatorClick = { viewModel.operatorAppend(action = it) },
            onDelete =
            {
                try {
                    if (it == "AC") viewModel.deleteAll()
                    else viewModel.deleteLast()
                }
                catch (e: Exception) {}
            })
    }
}




@Composable
private fun CalcKeyboard(modifier: Modifier = Modifier,
                         onValueClick: (String) -> Unit,
                         onOperatorClick: (String) -> Unit,
                         onDelete: (String) -> Unit)
{
    Column(modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row(modifier = modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            CalcButton(
                value = "AC",
                onClick = { onDelete("AC") },
                backgroundColor = Color.LightGray,
                textColor = Color.DarkGray
            )
            CalcButton(
                value = "(",
                onClick = { /*TODO*/ },
                backgroundColor = Color.LightGray,
                textColor = Color.DarkGray
            )
            CalcButton(
                value = ")",
                onClick = { /*TODO*/ },
                backgroundColor = Color.LightGray,
                textColor = Color.DarkGray
            )
            CalcButton(
                value = "÷",
                onClick = { onOperatorClick("÷") },
                backgroundColor = Color.Red,
                textColor = Color.DarkGray
            )
        }
        Row(modifier = modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp))
        {
            CalcButton(
                value = "7",
                onClick = { onValueClick("7") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "8",
                onClick = { onValueClick("8") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "9",
                onClick = { onValueClick("9") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "x",
                onClick = { onOperatorClick("x") },
                backgroundColor = Color.Red,
                textColor = Color.DarkGray
            )
        }
        Row(modifier = modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp))
        {
            CalcButton(
                value = "4",
                onClick = { onValueClick("4") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "5",
                onClick = { onValueClick("5") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "6",
                onClick = { onValueClick("6") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "-",
                onClick = { onOperatorClick("-") },
                backgroundColor = Color.Red,
                textColor = Color.DarkGray
            )
        }
        Row(modifier = modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp))
        {
            CalcButton(
                value = "1",
                onClick = { onValueClick("1") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "2",
                onClick = { onValueClick("2") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "3",
                onClick = { onValueClick("3") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = "+",
                onClick = { onOperatorClick("+") },
                backgroundColor = Color.Red,
                textColor = Color.DarkGray
            )
        }
        Row(modifier = modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp))
        {
            CalcButton(
                value = "0",
                onClick = { onValueClick("0") },
                backgroundColor = Color.DarkGray,
                textColor = Color.LightGray
            )
            CalcButton(
                value = ",",
                onClick = { onOperatorClick(",") },
                backgroundColor = Color.LightGray,
                textColor = Color.DarkGray
            )
            CalcButton(
                value = "DEL",
                onClick = { onDelete("DEL") },
                backgroundColor = Color.LightGray,
                textColor = Color.DarkGray
            )
            CalcButton(
                value = "=",
                onClick = { onOperatorClick("=") },
                backgroundColor = Color.Red,
                textColor = Color.DarkGray
            )
        }
    }
}






@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    MyCalculatorTheme {
        CalculatorScreen(modifier = Modifier, viewModel = CalculatorViewModel())
    }
}

/*
@Preview(showBackground = true)
@Composable
fun CalcKeyboardPreview() {
    MyCalculatorTheme {
        CalcKeyboard(modifier = Modifier, onClick = {})
    }
}
 */