package com.example.appcafeleblanc.ui.utils

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun obtenerWindowSizeClass(): WindowWidthSizeClass {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp  // Obtiene el ancho de la pantalla en DP

    return when {
        screenWidthDp < 600 -> WindowWidthSizeClass.Compact
        screenWidthDp < 840 -> WindowWidthSizeClass.Medium
        else -> WindowWidthSizeClass.Expanded
    }
}