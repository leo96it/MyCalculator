import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.MyCalculatorTheme

@Composable
fun ResultDisplay(result: String,
                  operation: String,
                  modifier: Modifier = Modifier
)
{
    Column(modifier = modifier)
    {
        LazyRow(
            horizontalArrangement = Arrangement.End,
            modifier = modifier.fillMaxWidth(),
            reverseLayout = true
        )
        {
            item()
            {
                Text(text = operation,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(top = 32.dp)
                        .fillMaxWidth()
                        .then(modifier),
                    color = Color.Gray,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.End,
            modifier = modifier.fillMaxWidth(),
            reverseLayout = true
        )
        {
            item()
            {
                Text(text = result,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 15.dp)
                        .fillMaxWidth()
                        .then(modifier),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ResultDisplayPreview() {
    MyCalculatorTheme {
        ResultDisplay(modifier = Modifier, operation = "58 x 8 =", result = "1.1")
    }
}