package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
// << NUEVAS IMPORTACIONES >>
import com.example.appcafeleblanc.ui.theme.* import com.example.appcafeleblanc.ui.components.* // Importa los componentes ahora desde 'components'

@Composable
fun HomeScreenExpandida() {
    Scaffold(
        containerColor = LeBlancDark,
        topBar = { HeaderLeBlanc() }
    ) { paddingValues ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Columna 1: Menú Principal (65% del ancho)
            LazyColumn(
                modifier = Modifier
                    .weight(0.65f)
                    .fillMaxHeight(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                item { CategoriaMenu(titulo = "Café & Bebidas") }
                // <<<< LIMPIO: Ya no necesita onCartUpdate = {} >>>>
                item { ItemMenuCard("Blue Mountain Blend", "¥ 5,000") }
                item { ItemMenuCard("Café y Té", "¥ 300") }

                item { CategoriaMenu(titulo = "Platos Calientes (Curry)") }
                item { ItemMenuCard("Curry Especial del Jefe", "¥ 850") }
                item { ItemMenuCard("Curry con Tonkatsu", "¥ 1,200") }

                item { CategoriaMenu(titulo = "Postres & Dulces") }
                item { ItemMenuCard("Panqueques Secretos", "¥ 700") }
                item { ItemMenuCard("Pastel de Matcha", "¥ 650") }

                item { Spacer(modifier = Modifier.height(32.dp)) }
            }

            // Columna 2: Carrito Fijo / Pedido Actual (35% del ancho)
            Surface(
                modifier = Modifier
                    .weight(0.35f)
                    .fillMaxHeight(),
                color = LeBlancMedium
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Contenido Superior: Título y Lista
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "Tu Pedido Actual",
                            style = MaterialTheme.typography.titleLarge.copy(fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold),
                            color = LeBlancText
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "Aún no hay items. ¡Elige algo!",
                            color = LeBlancText.copy(alpha = 0.6f)
                        )
                    }

                    // Contenido Inferior: Total y Botón de Pago
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("TOTAL: ¥ 0", style = MaterialTheme.typography.headlineSmall, color = LeBlancMystery)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* Checkout */ },
                            colors = ButtonDefaults.buttonColors(containerColor = LeBlancAccent),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Filled.ShoppingCart, contentDescription = "Pagar", tint = LeBlancText)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Pagar Ahora", color = LeBlancText)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 900, heightDp = 891)
@Composable
fun HomeScreenExpandidaPreview() {
    AppCafeLeBlancTheme {
        HomeScreenExpandida()
    }
}