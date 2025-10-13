package com.example.appcafeleblanc.ui.screens

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcafeleblanc.ui.utils.obtenerWindowSizeClass // Necesitas esta importación
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme
// Debes importar las funciones de diseño que crearás
// import com.example.appcafeleblanc.ui.screens.HomeScreenCompacta
// import com.example.appcafeleblanc.ui.screens.HomeScreenMediana
// import com.example.appcafeleblanc.ui.screens.HomeScreenExpandida


/**
 * Función principal que detecta el tamaño de la ventana y llama a la vista adecuada.
 * (Cumple con la Parte 3, punto 4 de la guía).
 */
@Composable
fun HomeScreen() {
    val windowSizeClass = obtenerWindowSizeClass() // 1. Llama a la utilidad de tamaño

    // 2. Decide qué vista mostrar según el ancho de la pantalla
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta() // Llama a tu diseño estático
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        WindowWidthSizeClass.Expanded -> HomeScreenExpandida()
    }
}


/**
 * Preview del punto de control principal.
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppCafeLeBlancTheme {
        // Ejecuta el punto de control adaptable en el Preview
        HomeScreen()
    }
}