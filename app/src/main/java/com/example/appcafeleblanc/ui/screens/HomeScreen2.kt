package com.example.appcafeleblanc.ui.screens // ¡Tu paquete base AQUI!

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
// Debes cambiar el paquete de utils al tuyo:
import com.example.appcafeleblanc.ui.utils.obtenerWindowSizeClass
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme // Para el Preview

/**
 * Función principal que detecta el tamaño de la ventana y llama a la vista adecuada.
 * (Cumple con la Parte 3, punto 4 de la guía).
 */
@Composable
fun HomeScreen2() { // fun HomeScreen2() [cite: 132]
    val windowSizeClass = obtenerWindowSizeClass() // Llamada a la utilidad

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta() // Llama a la vista pequeña [cite: 134]
        WindowWidthSizeClass.Medium -> HomeScreenMediana() // Llama a la vista mediana [cite: 134]
        WindowWidthSizeClass.Expanded -> HomeScreenExpandida() // Llama a la vista expandida [cite: 137]
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreen2Preview() {
    AppCafeLeBlancTheme {
        // Ejecuta el punto de control adaptable en el Preview
        HomeScreen2()
    }
}