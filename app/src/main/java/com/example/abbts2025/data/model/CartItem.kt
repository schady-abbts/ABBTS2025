package com.example.abbts2025.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CartItem(
    val product: Product,
    var quantity: Int = 1
)
