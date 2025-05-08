package com.example.abbts2025.data.model

data class Review(
    val productId: Int,
    val username: String,
    val rating: Int, // 1–5
    val comment: String
)
