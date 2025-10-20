package com.example.appcafeleblanc.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcafeleblanc.data.MenuItem
import com.example.appcafeleblanc.data.sampleMenuItems
// Importamos la definición de CartState desde el paquete de datos
import com.example.appcafeleblanc.data.CartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MenuViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<CartState>(emptyMap())
    // Expone el estado del carrito
    val cartItems: StateFlow<CartState> = _cartItems

    // Mapa de ítems para búsqueda rápida y cálculo
    private val menuMap: Map<String, MenuItem> = sampleMenuItems.associateBy { it.id }

    // Calcula el total del carrito observando _cartItems
    val cartTotal: StateFlow<Int> = _cartItems.map { cartMap ->
        cartMap.entries.sumOf { (itemId, quantity) ->
            val itemPrice = menuMap[itemId]?.price ?: 0
            itemPrice * quantity
        }
    }.stateIn(
        scope = viewModelScope,
        // Configuración estándar para mantener el flujo activo mientras la UI lo observa
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )


    /**
     * Añade o remueve un ítem del carrito.
     * @param itemId ID del producto.
     * @param change Cantidad a añadir (+1) o remover (-1).
     */
    fun updateItemQuantity(itemId: String, change: Int) {
        _cartItems.update { currentMap ->
            val currentQuantity = currentMap[itemId] ?: 0
            val newQuantity = currentQuantity + change

            if (newQuantity <= 0) {
                // Si la cantidad es cero o menor, se elimina del mapa
                currentMap.toMutableMap().apply { remove(itemId) }
            } else {
                // Se actualiza la cantidad
                currentMap.toMutableMap().apply { put(itemId, newQuantity) }
            }
        }
    }

    // Obtiene un item por su ID
    fun getItemById(itemId: String): MenuItem? = menuMap[itemId]

    // Función para limpiar el carrito (usada al simular el pago)
    fun clearCart() {
        _cartItems.value = emptyMap()
    }
}