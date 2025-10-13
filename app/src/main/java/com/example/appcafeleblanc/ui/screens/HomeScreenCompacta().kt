package com.example.appcafeleblanc.ui.screens // 1. Paquete CORREGIDO

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcafeleblanc.R // 2. Referencia a recursos CORREGIDA
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme // 3. Importación del tema de tu app

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCompacta() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Mi App Kotlin") }) // [cite: 72]
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = innerPadding) // [cite: 82]
                .fillMaxSize() // [cite: 84]
                .padding(all = 15.dp),
            verticalArrangement = Arrangement.spacedBy(space = 20.dp) // [cite: 87-88]
        ) {
            Text(
                text = "¡Bienvenido!", // [cite: 97]
                color = MaterialTheme.colorScheme.primary, // [cite: 98]
                style = MaterialTheme.typography.titleLarge // [cite: 99]
            )

            Button(onClick = { /* acción futura */ }) { // [cite: 100]
                Text(text = "Presióname") // [cite: 101]
            }

//            Image(
//                painter = painterResource(id = R.drawable.logo), // [cite: 109]
//                contentDescription = "Logo App", // [cite: 110]
//                modifier = Modifier
//                    .fillMaxWidth() // [cite: 112]
//                    .height(height = 150.dp), // [cite: 113]
//                contentScale = ContentScale.Fit // [cite: 114, 118]
//            )
        }
    }
}

// -----------------------------------------------------------

@Preview(name = "Compact", widthDp = 360, heightDp = 800) // [cite: 139]
@Composable
fun PreviewCompact() {
    // Usar el tema de tu aplicación
    AppCafeLeBlancTheme {
        HomeScreenCompacta()
    }
}