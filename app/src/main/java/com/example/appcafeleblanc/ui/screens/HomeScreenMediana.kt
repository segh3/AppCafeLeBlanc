package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcafeleblanc.ui.theme.LeBlancAccent
import com.example.appcafeleblanc.ui.theme.LeBlancDark
import com.example.appcafeleblanc.ui.theme.LeBlancText
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme

@Composable
fun HomeScreenMediana() {
    Scaffold(
        containerColor = LeBlancDark,
        topBar = { HeaderLeBlanc() },
        floatingActionButton = {
            // Mantenemos el FAB, pero podemos hacerlo más pequeño
            FloatingActionButton(
                onClick = { /* Ir a la pantalla de pedido */ },
                containerColor = LeBlancAccent,
            ) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito", tint = LeBlancText)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        // Usamos LazyColumn, pero los elementos tienen más espacio horizontal
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 48.dp), // Añadimos margen lateral
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            // Reutilizamos el mismo contenido de menú
            item { CategoriaMenu(titulo = "Café & Bebidas") }
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
    }
}

@Preview(showBackground = true, widthDp = 650, heightDp = 891)
@Composable
fun HomeScreenMedianaPreview() {
    AppCafeLeBlancTheme {
        HomeScreenMediana()
    }
}