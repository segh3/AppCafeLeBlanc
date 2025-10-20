package com.example.appcafeleblanc.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcafeleblanc.ui.theme.* // --- 1. ENCABEZADO ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderLeBlanc() {
    TopAppBar(
        title = {
            Column {
                Text(
                    "Café LeBlanc",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    color = LeBlancText
                )
                Text(
                    "Bienvenido, ¿Qué desea ordenar?",
                    style = MaterialTheme.typography.bodySmall,
                    color = LeBlancText.copy(alpha = 0.7f)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LeBlancDark
        )
    )
}

// --- 2. CATEGORÍA ---
@Composable
fun CategoriaMenu(titulo: String) {
    Text(
        text = titulo,
        style = MaterialTheme.typography.titleLarge,
        color = LeBlancAccent,
        modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp)
    )
    Divider(color = LeBlancAccent.copy(alpha = 0.5f), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
}

// --- 3. TARJETA DE ITEM CON CONTADOR ---
@Composable
fun ItemMenuCard(
    // << CORRECCIÓN 1: AÑADIDO ID >>
    id: String,
    nombre: String,
    precio: String,
    // << CORRECCIÓN 2: onCartUpdate ahora requiere el ID y es opcional >>
    onCartUpdate: (id: String, change: Int) -> Unit = { _, _ -> }
) {
    var cantidad by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = LeBlancMedium
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Información del Ítem
            Column(modifier = Modifier.weight(1f)) {
                Text(nombre, style = MaterialTheme.typography.titleMedium.copy(fontFamily = FontFamily.Serif), color = LeBlancText)
                Spacer(modifier = Modifier.height(4.dp))
                Text(precio, style = MaterialTheme.typography.titleSmall, color = LeBlancMystery)
            }

            // Contador de Cantidad
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Botón Restar
                IconButton(
                    onClick = {
                        if (cantidad > 0) {
                            cantidad--
                            // << USANDO ID EN EL CALLBACK >>
                            onCartUpdate(id, -1)
                        }
                    },
                    modifier = Modifier.size(32.dp),
                    colors = IconButtonDefaults.iconButtonColors(contentColor = LeBlancText)
                ) {
                    Icon(Icons.Filled.Delete, contentDescription = "Restar")
                }

                // Cantidad
                Text(
                    text = cantidad.toString(),
                    color = LeBlancText,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.widthIn(min = 20.dp).align(Alignment.CenterVertically)
                )

                // Botón Sumar
                Button(
                    onClick = {
                        cantidad++
                        // << USANDO ID EN EL CALLBACK >>
                        onCartUpdate(id, 1)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = LeBlancAccent),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Añadir", tint = LeBlancText)
                }
            }
        }
    }
}

// --- 4. OFERTA BANNER ---
@Composable
fun OfertaBanner(titulo: String, subtitulo: String) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(140.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LeBlancAccent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    titulo,
                    style = MaterialTheme.typography.headlineSmall.copy(fontFamily = FontFamily.Serif),
                    fontWeight = FontWeight.Bold,
                    color = LeBlancText
                )
                Text(
                    subtitulo,
                    style = MaterialTheme.typography.bodySmall,
                    color = LeBlancText.copy(alpha = 0.8f)
                )
            }
            Text(
                "¡Especial!",
                color = LeBlancMystery,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .border(1.dp, LeBlancMystery, RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp)
            )
        }
    }
}