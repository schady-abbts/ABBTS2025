package com.example.abbts2025.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abbts2025.data.model.Cart
import com.example.abbts2025.data.model.CartItem
import com.example.abbts2025.data.model.Product
import com.example.abbts2025.data.persistence.CartPersistence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel(
    private val persistence: CartPersistence
) : ViewModel() {

    private val _cart = MutableStateFlow(Cart())
    val cart: StateFlow<Cart> = _cart

    init {
        viewModelScope.launch {
            cart
                .drop(1) // ignoriere den ersten leeren Zustand
                .distinctUntilChanged() // verhindere Dauerschleife bei identischen Werten
                .collect { newCart ->
                    try {
                        persistence.save(newCart)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
        }
    }

    fun loadCart() {
        viewModelScope.launch {
            try {
                persistence.load()?.let {
                    _cart.value = it
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addToCart(product: Product) {
        _cart.update { cart ->
            val updatedItems = cart.items.toMutableList()
            val index = updatedItems.indexOfFirst { it.product.id == product.id }
            if (index >= 0) {
                val existing = updatedItems[index]
                updatedItems[index] = existing.copy(quantity = existing.quantity + 1)
            } else {
                updatedItems.add(CartItem(product))
            }
            Cart(items = updatedItems)
        }
    }

    fun removeFromCart(productId: Int) {
        _cart.update { cart ->
            val updatedItems = cart.items.filterNot { it.product.id == productId }
            Cart(items = updatedItems)
        }
    }

    fun clearCart() {
        _cart.value = Cart()
    }
}
