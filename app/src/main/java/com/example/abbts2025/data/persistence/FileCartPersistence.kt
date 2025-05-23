package com.example.abbts2025.data.persistence

import android.content.Context
import com.example.abbts2025.data.model.Cart
import com.example.abbts2025.data.repository.CartStorage

class FileCartPersistence(private val context: Context) : CartPersistence {
    override suspend fun save(cart: Cart) {
        CartStorage.saveCart(context, cart)
    }

    override suspend fun load(): Cart? {
        return CartStorage.loadCart(context)
    }
}
