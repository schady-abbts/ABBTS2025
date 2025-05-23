package com.example.abbts2025.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.Grass
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
enum class Category(
    val label: String,
    @Transient val icon: ImageVector
) {
    @SerialName("Alle")
    Alle("Alle", Icons.Filled.Category),

    @SerialName("Obst")
    Obst("Obst", Icons.Filled.Eco),

    @SerialName("Gemuese")
    Gemuese("Gemüse", Icons.Filled.Grass),

    @SerialName("Feinkost")
    Feinkost("Feinkost", Icons.Filled.EmojiFoodBeverage);
}
