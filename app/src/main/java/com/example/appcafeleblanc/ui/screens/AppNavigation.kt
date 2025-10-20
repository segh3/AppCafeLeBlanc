package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcafeleblanc.ui.viewmodel.MenuViewModel
import com.example.appcafeleblanc.ui.theme.*
import com.example.appcafeleblanc.ui.components.HeaderLeBlanc

// Rutas de navegación selladas para evitar errores de tipeo
sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Checkout : Screen("checkout_screen")
}

@Composable
fun AppNavigation() {
    // Aseguramos que el tema se aplique a todo el NavHost
    AppCafeLeBlancTheme {
        // 1. Inicializa el controlador de navegación
        val navController = rememberNavController()

        // 2. Crea y recuerda el ViewModel para compartirlo entre todas las pantallas
        val menuViewModel: MenuViewModel = viewModel()

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route // Pantalla inicial
        ) {

            // 1. Pantalla Principal (Menú Adaptable)
            composable(Screen.Home.route) {
                // Requiere que la función HomeScreen reciba (MenuViewModel, () -> Unit)
                HomeScreen(
                    menuViewModel = menuViewModel,
                    onNavigateToCheckout = { navController.navigate(Screen.Checkout.route) }
                )
            }

            // 2. Pantalla de Pago
            composable(Screen.Checkout.route) {
                // Requiere que la función CheckoutScreen reciba (MenuViewModel, () -> Unit)
                CheckoutScreen(
                    menuViewModel = menuViewModel,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}

// **CheckoutScreen.kt (Lo incluimos aquí temporalmente)**
@Composable
fun CheckoutScreen(menuViewModel: MenuViewModel, onNavigateBack: () -> Unit) {
    // Observa el total del carrito del ViewModel
    val total by menuViewModel.cartTotal.collectAsState()

    Scaffold(
        topBar = { HeaderLeBlanc() },
        containerColor = LeBlancDark
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "RESUMEN DEL PEDIDO",
                style = MaterialTheme.typography.headlineMedium,
                color = LeBlancAccent
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                "Total a pagar:",
                style = MaterialTheme.typography.titleLarge,
                color = LeBlancText
            )
            Text(
                "¥$total",
                style = MaterialTheme.typography.headlineLarge,
                color = LeBlancMystery,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = {
                    menuViewModel.clearCart() // Llama a la función que añadimos al VM
                    onNavigateBack() // Vuelve al menú
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = total > 0,
                colors = ButtonDefaults.buttonColors(containerColor = LeBlancAccent)
            ) {
                Text(if (total > 0) "Confirmar Pago" else "Carrito Vacío", color = LeBlancText)
            }
        }
    }
}