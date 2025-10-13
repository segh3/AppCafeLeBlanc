package com.example.appcafeleblanc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// Importación de tu tema y de la pantalla principal
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme
import com.example.appcafeleblanc.ui.screens.HomeScreen // <--- Importante: La nueva ubicación

/**
 * Actividad principal que carga y muestra la interfaz de usuario.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppCafeLeBlancTheme {
                // Llama al Composable HomeScreen que contiene la lógica ADAPTABLE.
                HomeScreen() // [cite: 153]
            }
        }
    }
}

// Se eliminan los @Composable HomeScreen y @Preview de este archivo.
// Ahora están en ui/screens/HomeScreen.kt