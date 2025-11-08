package com.example.a27
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a27.ui.theme.Theme_27

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme_27 {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // ContactColumn()
                    ContactRow()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactColumn() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FirstComposeProject") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ContactCard(
                FirstName = "Имя: Евгений",
                Patronymic = "Отчество: Андреевич",
                LastName = "Фамилия: Лукашин",
                phone = "Мобильный телефон: +7 495 495 95 95",
                address = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12"
            )
            ContactCard(
                FirstName = "Имя: Василий",
                Patronymic = "Отчество: Егорович",
                LastName = "Фамилия: Кузякин",
                phone = "Мобильный телефон: ---",
                address = "Адрес: Ивановская область, дер. Крутово, д. 4"
            )
            ContactCard(
                FirstName = "Имя: Людмила",
                Patronymic = "Прокофьевна",
                LastName = "Калугина",
                phone = "Мобильный телефон: +7 495 788 78 78",
                address = "Адрес: Москва, Большая Никитская, д. 43, кв. 290"
            )
        }
    }
}

@Composable
fun ContactCard(
    FirstName: String,
    Patronymic: String,
    LastName: String,
    phone: String,
    address: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = FirstName,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = Patronymic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = LastName,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = phone,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = address,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactRow() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FirstComposeProject") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RowContactCard(
                FirstName = "Имя: Евгений",
                Patronymic = "Отчество: Андреевич",
                LastName = "Фамилия: Лукашин",
                phone = "Мобильный телефон: +7 495 495 95 95",
                address = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                imageRes = android.R.drawable.ic_menu_compass
            )
        }
    }
}

@Composable
fun RowContactCard(
    FirstName: String,
    Patronymic: String,
    LastName: String,
    phone: String,
    address: String,
    imageRes: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = FirstName,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = Patronymic,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = LastName,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = phone,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = address,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Contact Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RectangleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Theme_27 {
        ContactColumn()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Theme_27 {
        ContactRow()
    }
}