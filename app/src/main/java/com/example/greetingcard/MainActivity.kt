package com.example.greetingcard

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ScrollView
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    GreetingImage(
                        headline = stringResource(R.string.headline_text),
                        message = stringResource(R.string.shorter_text),
                        from = stringResource(R.string.app_info_text),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
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
fun justTrying() {
    Text(
        text = "Button",
        fontSize = 25.sp,
        color = Color.Red,
        textAlign = TextAlign.End
    )
}

@Composable
fun GreetingText(headline : String, message: String, from: String, modifier: Modifier = Modifier) {
    Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(40.dp)
        ) {
            Text(
                text = headline,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                
            )
            Text(
                text = message,
                textAlign = TextAlign.Justify,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .background(color = Color.White)
            )
            Text(
                text = from,
                fontSize = 15.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .background(color = Color.White)
            )

        }


}
@Composable
fun GreetingImage(headline: String, message: String, from: String, modifier: Modifier = Modifier) {
    var numeroVaihtuva by remember { mutableStateOf(1) }
    val image = when (numeroVaihtuva) {
        1 -> R.drawable.yoyo
        else -> R.drawable.bg_compose_background
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 40.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            alpha = 0.8f,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { numeroVaihtuva = 2 }) {
            Text(
                text = "change",
                fontSize = 25.sp,
                color = Color.LightGray,
            )
            Alignment.Center

        }
        GreetingText(
            headline = headline,
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                // .padding(8.dp)
                .background(color = Color.White)
        )
        Text(text = stringResource(R.string.last_messagee))
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    GreetingCardTheme {
        GreetingImage(
            headline = stringResource(R.string.headline_text),
            message = stringResource(R.string.shorter_text),
            from = stringResource(R.string.app_info_text)
        )
    }
}