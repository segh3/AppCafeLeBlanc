package com.example.appcafeleblanc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Importaciones necesarias para los COMPONENTES definidos al final del archivo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
// Importación de tu tema de aplicación
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme
import com.example.appcafeleblanc.R

/**
 * Actividad principal que carga y muestra la interfaz de usuario.
 * Define la UI directamente con setContent.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el modo 'Edge-to-Edge' para usar toda la pantalla.
        enableEdgeToEdge()

        setContent {
            // Aplica el tema de la aplicación a toda la jerarquía de UI.
            AppCafeLeBlancTheme {
                // Llama al Composable HomeScreen.
                // Al estar definido en este archivo, actúa como un elemento "propio".
                HomeScreen()
            }
        }
    }
}

// ----------------------------------------------------------------------------------

/**
 * Función Composable que define la estructura principal de la pantalla de inicio (HomeScreen).
 * Contiene el Scaffold con la barra superior y el contenido principal.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // Scaffold implementa la estructura básica (TopBar y cuerpo)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mi App Kotlin") })
        }
    ) { innerPadding ->
        Column(
            // Aplica el padding de Scaffold, ocupa el tamaño máximo y añade padding de 16dp
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            // Espaciado uniforme de 20dp entre los elementos.
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "¡Bienvenido!")

            Button(onClick = { /* acción futura */ }) {
                Text("Presióname")
            }

//            // Se reinserta el código de la Image para que se muestre, asumiendo que R.drawable.logo existe.
//            Image(
//                painter = painterResource(id = R.drawable.logo),
//                contentDescription = "Logo App",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(150.dp),
//                contentScale = ContentScale.Fit
//            )
        }
    }
}

// ----------------------------------------------------------------------------------

/**
 * Función de previsualización para el HomeScreen.
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppCafeLeBlancTheme {
        HomeScreen()
    }
}