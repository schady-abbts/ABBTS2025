package com.example.abbts2025.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.LocalGroceryStore
import androidx.compose.ui.graphics.vector.ImageVector

enum class Category(val label: String, val icon: ImageVector) {
    Alle("Alle", Icons.Filled.Category),
    Obst("Obst", Icons.Filled.LocalGroceryStore),
    Gemuese("Gemüse", Icons.Filled.Grass),
    Feinkost("Feinkost", Icons.Filled.EmojiFoodBeverage)
}
