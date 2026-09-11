package com.example.a23
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a23.ui.theme.a23Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            a23Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    GreenText()
                    OneLineText()
                    GreenBack()
                }
            }
        }
    }
}

@Composable
fun GreenText() {
    Text(
        text = stringResource(R.string.jetpack_description),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun OneLineText() {
    Text(
        text = stringResource(R.string.jetpack_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun GreenBack() {
    Text(
        text = stringResource(R.string.jetpack_description),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(start = 48.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
    )
}

@Preview(showBackground = true, name = "1")
@Composable
fun GreenTextPreview() {
    a23Theme {
        GreenText()
    }
}

@Preview(showBackground = true, name = "2")
@Composable
fun OneLineTextPreview() {
    a23Theme {
        OneLineText()
    }
}

@Preview(showBackground = true, name = "3")
@Composable
fun GreenBackPreview() {
    a23Theme {
        GreenBack()
    }
}