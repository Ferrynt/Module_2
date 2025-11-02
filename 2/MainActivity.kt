package com.example.a22
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hello(name = "Андрей")
        }}}

@Composable
fun Hello(name: String?) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        modifier = Modifier.padding(top = 30.dp)
    )
}

@Preview(
    name = "Portrait",
    showBackground = true,
    device = Devices.PIXEL_2,
    showSystemUi = true
)
@Composable
fun PortraitPreview() {
    Hello(
        name = "Андрей"
    )
}

@Preview(
    name = "Landscape",
    device = "spec:parent=pixel_2, orientation=landscape",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LandscapePreview() {
    Hello(
        name = "Андрей"
    )
}

@Preview(
    name = "Round",
    showBackground = true,
    widthDp = 200,
    heightDp = 200,
    showSystemUi = false
)
@Composable
fun RoundPreview() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Hello(name = "Андрей")
    }
}