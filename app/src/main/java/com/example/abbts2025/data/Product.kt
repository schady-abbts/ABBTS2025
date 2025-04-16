package com.example.abbts2025.data


data class Product(
    val id: Int,
    val name: String,
    val producer: String,
    val category: String,
    val description: String,
    val price: Double,
    val priceFormatted: String, // CHF z. B.
    val unit: String,
    val available: Boolean,
    val tags: List<String>,
    val imageResId: Int
)
