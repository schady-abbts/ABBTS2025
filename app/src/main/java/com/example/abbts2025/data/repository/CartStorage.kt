package com.example.abbts2025.data.repository

import android.content.Context
import android.util.Log
import com.example.abbts2025.data.model.Cart
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object CartStorage {

    private const val FILE_NAME = "cart.json"
    private const val TAG = "CartStorage"

    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
        prettyPrint = true
        coerceInputValues = true
    }

    fun saveCart(context: Context, cart: Cart) {
        try {
            val file = File(context.filesDir, FILE_NAME)
            val data = json.encodeToString(cart)
            file.writeText(data)

            Log.d(TAG, "✅ Warenkorb gespeichert: ${cart.items.size} Artikel")
            Log.d(TAG, "📂 Speicherort: ${file.absolutePath}")
        } catch (e: Exception) {
            Log.e(TAG, "❌ Fehler beim Speichern des Warenkorbs", e)
        }
    }

    fun loadCart(context: Context): Cart? {
        return try {
            val file = File(context.filesDir, FILE_NAME)
            if (!file.exists()) {
                Log.w(TAG, "⚠️ cart.json nicht gefunden")
                return null
            }

            val text = file.readText()
            val loadedCart = json.decodeFromString<Cart>(text)

            Log.d(TAG, "✅ Warenkorb geladen: ${loadedCart.items.size} Artikel")
            loadedCart
        } catch (e: Exception) {
            Log.e(TAG, "❌ Fehler beim Laden des Warenkorbs", e)
            null
        }
    }
}
