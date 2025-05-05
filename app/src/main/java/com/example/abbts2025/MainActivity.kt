package com.example.abbts2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.abbts2025.data.Category
import com.example.abbts2025.ui.components.CategoryNavigationBar
import com.example.abbts2025.ui.navigation.MainNavHost
import com.example.abbts2025.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                var selectedCategory by remember { mutableStateOf(Category.Alle) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        CategoryNavigationBar(
                            selectedCategory = selectedCategory,
                            onCategorySelected = { category -> selectedCategory = category },
                            onMenuClick = { navController.navigate("main") }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainNavHost(
                            navController = navController,
                            selectedCategory = selectedCategory
                        )
                    }
                }
            }
        }
    }
}
