package com.example.greetingcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    GreetingText(
                        message = "Happy Birthday Sam!",
                        from = "From Emma!",
                        modifier = Modifier.padding(8.dp)

                    )
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hi, my name is $name!",
            modifier = modifier.padding(50.dp), color = Color.Red

        )
    }

}*/
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = message,
                textAlign = TextAlign.Center,
                fontSize = 100.sp,
                lineHeight = 80.sp
            )
            Text(
                text = from,
                fontSize = 36.sp,
                color = Color.Red,
                modifier = Modifier
                    .padding(8.dp)
                    .align(alignment = Alignment.End)
            )
        }

    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    GreetingCardTheme {
        GreetingText(message = "Happy bd sam!", from = "From hege!")
    }
}