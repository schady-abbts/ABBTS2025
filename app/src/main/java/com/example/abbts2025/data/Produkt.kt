package com.example.abbts2025.data

data class Produkt(
    val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val price: Double,
    val unit: String,
    val available: Boolean,
    val imageResId: Int
)