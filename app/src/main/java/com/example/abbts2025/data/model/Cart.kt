package com.example.abbts2025.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val items: List<CartItem> = emptyList()
) {
    val totalItemCount: Int get() = items.sumOf { it.quantity }
    val totalPrice: Double get() = items.sumOf { it.product.price * it.quantity }
    val isEmpty: Boolean get() = items.isEmpty()
}
