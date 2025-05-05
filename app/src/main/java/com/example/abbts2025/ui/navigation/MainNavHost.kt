package com.example.abbts2025.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.abbts2025.data.Category
import com.example.abbts2025.data.productList
import com.example.abbts2025.ui.screens.ProductListScreen
import com.example.abbts2025.ui.screens.ProductScreen

@Composable
fun MainNavHost(navController: NavHostController, selectedCategory: Category) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            val filteredProducts = if (selectedCategory == Category.Alle) {
                productList
            } else {
                productList.filter { it.category == selectedCategory }
            }
            ProductListScreen(
                productList = filteredProducts,
                modifier = Modifier.padding(all = 24.dp),
                navController = navController,
                selectedCategory = selectedCategory
            )
        }

        composable("product") {
            ProductScreen(navController = navController)
        }
    }
}
