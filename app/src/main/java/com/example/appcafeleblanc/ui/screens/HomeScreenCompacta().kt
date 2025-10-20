package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcafeleblanc.ui.theme.LeBlancAccent
import com.example.appcafeleblanc.ui.theme.LeBlancDark
import com.example.appcafeleblanc.ui.theme.LeBlancText
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme
// << CORRECCIÓN >> Importa los componentes ahora desde el paquete 'components'
import com.example.appcafeleblanc.ui.components.* @Composable
fun HomeScreenCompacta() {
    // Estado local simulado del carrito (reemplaza por ViewModel real)
    var cartCount by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = LeBlancDark,
        topBar = { HeaderLeBlanc() },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* Navegar al carrito */ },
                containerColor = LeBlancAccent,
                icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito", tint = LeBlancText) },
                // Muestra la cantidad de ítems en el carrito
                text = { Text("Carrito ($cartCount)", color = LeBlancText) }
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {

            // SECCIÓN: Banner de Promociones (LazyRow)
            item {
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    item { OfertaBanner("Curry Especial", "¡Doble porción de arroz hoy!") }
                    item { OfertaBanner("Blend de Sojiro", "El mejor café de Shujin.") }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // 1. Café Especial
            item { CategoriaMenu(titulo = "Café & Bebidas") }
            // << IMPORTANTE >> El onCartUpdate se mantiene aquí, ya que actualiza el cartCount.
            item { ItemMenuCard("Blue Mountain Blend", "¥ 5,000") { change -> cartCount += change } }
            item { ItemMenuCard("Café y Té", "¥ 300") { change -> cartCount += change } }

            // 2. Platos Calientes Japoneses
            item { CategoriaMenu(titulo = "Platos Calientes (Curry)") }
            item { ItemMenuCard("Curry Especial del Jefe", "¥ 850") { change -> cartCount += change } }
            item { ItemMenuCard("Curry con Tonkatsu", "¥ 1,200") { change -> cartCount += change } }

            // 3. Postres
            item { CategoriaMenu(titulo = "Postres & Dulces") }
            item { ItemMenuCard("Panqueques Secretos", "¥ 700") { change -> cartCount += change } }
            item { ItemMenuCard("Pastel de Matcha", "¥ 650") { change -> cartCount += change } }

            item { Spacer(modifier = Modifier.height(32.dp)) }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 891)
@Composable
fun HomeScreenCompactaPreview() {
    AppCafeLeBlancTheme {
        HomeScreenCompacta()
    }
}