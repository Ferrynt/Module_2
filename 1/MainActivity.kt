package com.example.a21
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hello(name = "Андрей")
            //Hello(name = null)
        }}}

@Composable
fun Hello(name: String?) {
    Text(text = if (name != null) "Привет, $name!" else "Имя не задано",)
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Hello(name = "Имя")
}