package com.example.appcafeleblanc.ui.utils // Tu paquete base

import android.app.Activity // [cite: 45] (Nueva importación necesaria para el cast)
import androidx.activity.compose.LocalActivity // [cite: 38]
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi // [cite: 39]
import androidx.compose.material3.windowsizeclass.WindowSizeClass // [cite: 40]
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass // [cite: 41]
import androidx.compose.runtime.Composable // [cite: 42]

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class) // [cite: 43]
@Composable
fun obtenerWindowSizeClass(): WindowSizeClass { // [cite: 44]
    // Se utiliza el casteo a 'Activity' para que la función acepte el parámetro.
    return calculateWindowSizeClass(LocalActivity.current as Activity) // [cite: 45]
}