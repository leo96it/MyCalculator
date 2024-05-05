import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.MyCalculatorTheme


@Composable
fun CalcButton(value: String,
               onClick: (String) -> Unit,
               backgroundColor: Color,
               textColor: Color,
               modifier: Modifier = Modifier
)
{
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick(value) }
            .then(modifier)
    )
    {
        Text(
            text = value,
            modifier = modifier,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 36.sp,
            color = textColor
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    MyCalculatorTheme {
        CalcButton(modifier = Modifier,
            value = "1",
            backgroundColor = Color.DarkGray,
            textColor = Color.LightGray,
            onClick = {})
    }
}