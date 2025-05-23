package com.example.abbts2025.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abbts2025.data.persistence.CartPersistence
import com.example.abbts2025.data.persistence.FileCartPersistence

class CartViewModelFactory(
    private val context: Context,
    private val strategy: PersistenceType
) : ViewModelProvider.Factory {

    enum class PersistenceType {
        NONE,
        FILE,
        ROOM,
        SUPABASE
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val persistence: CartPersistence = when (strategy) {
            PersistenceType.FILE -> FileCartPersistence(context)
            PersistenceType.ROOM -> TODO("RoomCartPersistence not implemented")
            PersistenceType.SUPABASE -> TODO("SupabaseCartPersistence not implemented")
            PersistenceType.NONE -> object : CartPersistence {
                override suspend fun save(cart: com.example.abbts2025.data.model.Cart) = Unit
                override suspend fun load(): com.example.abbts2025.data.model.Cart? = null
            }
        }

        return CartViewModel(persistence) as T
    }
}
