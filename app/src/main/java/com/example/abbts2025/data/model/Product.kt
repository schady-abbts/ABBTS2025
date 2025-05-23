package com.example.abbts2025.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val producer: String,
    val category: Category,
    val description: String,
    val price: Double,
    val priceFormatted: String,
    val unit: String,
    val available: Boolean,
    val tags: List<String>,
    val imageResId: Int
)
