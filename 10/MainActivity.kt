package com.example.a210
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartScreen()
        }
    }

    @Composable
    fun ShoppingCartScreen() {
        var products by remember {
            mutableStateOf(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        }
        val totalSum = products.sumOf { it.price }
        val productCount = products.size
        val context = LocalContext.current

        Column {
            for (product in products) {
                Text(text = "${product.name} - ${product.price} рублей")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Товаров на сумму: $totalSum рублей")
            AddProductSection(
                onAdd = {
                    val newProduct = Product(
                        id = products.size,
                        name = "Товар #${products.size + 1}",
                        price = Random.nextInt(0, 100)
                    )
                    val oldSum = totalSum
                    val newSum = oldSum + newProduct.price
                    products = products + newProduct
                    if (oldSum <= 500 && newSum > 500) {
                        Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            RemoveProductSection(
                productCount = productCount,
                onRemove = {
                    products = products.dropLast(1)
                }
            )
        }
    }

    @Composable
    fun AddProductSection(
        onAdd: () -> Unit
    ) {
        Button(onClick = onAdd) {
            Text(text = "Добавить товар")
        }
    }

    @Composable
    fun RemoveProductSection(
        productCount: Int,
        onRemove: () -> Unit
    ) {
        if (productCount > 0) {
            Button(onClick = onRemove) {
                Text(text = "Удалить товар")
            }
        }
    }
}