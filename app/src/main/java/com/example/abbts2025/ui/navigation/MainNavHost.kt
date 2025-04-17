package com.example.abbts2025.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.abbts2025.data.productList
import com.example.abbts2025.ui.screens.MainScreen
import com.example.abbts2025.ui.screens.ProductScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(
                productList = productList,
                modifier = Modifier.padding(all = 24.dp),
                navController = navController
            )
        }

        composable("product") {
            ProductScreen(navController = navController)
        }
    }
}
