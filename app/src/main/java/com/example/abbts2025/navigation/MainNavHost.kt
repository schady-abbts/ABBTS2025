package com.example.abbts2025.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.abbts2025.data.model.Category
import com.example.abbts2025.data.repository.productList
import com.example.abbts2025.ui.screens.ProductListScreen
import com.example.abbts2025.ui.screens.ProductScreen
import com.example.abbts2025.ui.screens.ProductScreenWithState

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

        composable("product/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            productId?.let {
                ProductScreen(navController = navController, productId = it)
            }
        }

        composable("product_vm/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            productId?.let {
                ProductScreenWithState(navController = navController, productId = it)
            }
        }
    }
}
