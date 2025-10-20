package com.example.appcafeleblanc.data

data class MenuItem(
    val id: String,
    val name: String,
    val price: Int,
    val category: String
)

// Lista de datos estáticos para el menú
val sampleMenuItems = listOf(
    MenuItem("bm_blend", "Blue Mountain Blend", 5000, "Café & Bebidas"),
    MenuItem("coffee_tea", "Café y Té", 300, "Café & Bebidas"),
    MenuItem("curry_chef", "Curry Especial del Jefe", 850, "Platos Calientes"),
    MenuItem("curry_tonkatsu", "Curry con Tonkatsu", 1200, "Platos Calientes"),
    MenuItem("pancakes", "Panqueques Secretos", 700, "Postres & Dulces"),
    MenuItem("matcha", "Pastel de Matcha", 650, "Postres & Dulces")
)

// << AÑADE ESTO AQUÍ >>
// Definición del estado del carrito para ser usado globalmente
typealias CartState = Map<String, Int>