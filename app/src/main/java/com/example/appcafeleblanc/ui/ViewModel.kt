package com.example.appcafeleblanc.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcafeleblanc.data.MenuItem
import com.example.appcafeleblanc.data.sampleMenuItems
// Si CartState está en MenuItem.kt, usa esta importación:
// import com.example.appcafeleblanc.data.CartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.SharingStarted // Importación necesaria para stateIn
import kotlinx.coroutines.flow.stateIn // Importación necesaria para stateIn

// Define el tipo de estado para el carrito (SOLO SI NO ESTÁ EN MenuItem.kt)
typealias CartState = Map<String, Int>

class MenuViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<CartState>(emptyMap())
    // Expone el estado del carrito
    val cartItems: StateFlow<CartState> = _cartItems

    // Mapa de ítems para búsqueda rápida y cálculo
    private val menuMap: Map<String, MenuItem> = sampleMenuItems.associateBy { it.id }

    // Calcula el total del carrito observando los cambios en _cartItems
    val cartTotal: StateFlow<Int> = _cartItems.map { cartMap ->
        cartMap.entries.sumOf { (itemId, quantity) ->
            val itemPrice = menuMap[itemId]?.price ?: 0
            itemPrice * quantity
        }
    }.stateIn(
        scope = viewModelScope,
        // Usamos la clase estándar de Kotlin Coroutines
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )


    // Lógica para añadir/remover un ítem
    fun updateItemQuantity(itemId: String, change: Int) {
        _cartItems.update { currentMap ->
            val currentQuantity = currentMap[itemId] ?: 0
            val newQuantity = currentQuantity + change

            if (newQuantity <= 0) {
                // Eliminar ítem si la cantidad es cero o menor
                currentMap.toMutableMap().apply { remove(itemId) }
            } else {
                // Actualizar la cantidad
                currentMap.toMutableMap().apply { put(itemId, newQuantity) }
            }
        }
    }

    // Obtener un item por ID para mostrar detalles en el carrito fijo
    fun getItemById(itemId: String): MenuItem? = menuMap[itemId]

    // <<<< FUNCIÓN AÑADIDA PARA SOLUCIONAR EL ERROR DE CheckoutScreen >>>>
    fun clearCart() {
        _cartItems.value = emptyMap()
    }

    // <<<< ¡FUNCIÓN AUXILIAR ELIMINADA! >>>>
    // Se ha eliminado la función 'stateIn' que causaba el error de compilación.
}