package com.example.abbts2025.viewmodel

import androidx.lifecycle.ViewModel
import com.example.abbts2025.data.model.Product
import com.example.abbts2025.data.repository.productList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductDetailViewModel : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun loadProductById(id: Int) {
        _product.value = productList.find { it.id == id }
    }
}
