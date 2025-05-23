package com.example.abbts2025.data.persistence

import com.example.abbts2025.data.model.Cart

interface CartPersistence {
    suspend fun save(cart: Cart)
    suspend fun load(): Cart?
}
