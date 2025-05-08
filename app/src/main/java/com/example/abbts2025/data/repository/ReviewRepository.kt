package com.example.abbts2025.data.repository

import com.example.abbts2025.data.model.Review

val reviewList = mutableListOf(
    Review(1, "Nina", 5, "Sehr frisch und lecker!"),
    Review(1, "Ali", 4, "Gut, aber etwas zu weich."),
    Review(2, "Laura", 5, "Perfekt für Smoothies.")
)

fun getReviewsForProduct(productId: Int): List<Review> =
    reviewList.filter { it.productId == productId }

fun addReview(review: Review) {
    reviewList.add(review)
}
