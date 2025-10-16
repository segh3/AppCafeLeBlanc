package com.example.appcafeleblanc.ui.screens

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcafeleblanc.ui.utils.obtenerWindowSizeClass
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme
import com.example.appcafeleblanc.ui.screens.HomeScreenCompacta
import com.example.appcafeleblanc.ui.screens.HomeScreenMediana
import com.example.appcafeleblanc.ui.screens.HomeScreenExpandida

/**
 * Función principal que detecta el tamaño de la ventana y llama a la vista adecuada.
 * (Cumple con la Parte 3, punto 4 de la guía).
 */
// Reemplaza la línea 19:
// val windowSizeClass = remember { obtenerWindowSizeClass() }

@Composable
fun HomeScreen() {
    // Nueva línea 19: Llama directamente a la función Composable
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        WindowWidthSizeClass.Expanded -> HomeScreenExpandida()
        // El 'else' ya no es necesario si usas el valor devuelto directamente,
        // pero lo mantengo por si la librería oficial lo exige.
        else -> HomeScreenCompacta()
    }
}

/**
 * Preview del punto de control principal.
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppCafeLeBlancTheme {
        HomeScreen()  // Llama a HomeScreen en un contexto @Composable
    }
}