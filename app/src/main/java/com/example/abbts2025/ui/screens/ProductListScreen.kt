package com.example.abbts2025.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.abbts2025.data.model.Category
import com.example.abbts2025.data.model.Product
import com.example.abbts2025.ui.components.ProductCard

@Composable
fun ProductListScreen(
    productList: List<Product>,
    modifier: Modifier,
    navController: NavController,
    selectedCategory: Category
) {
    val listState = rememberLazyListState()
    LaunchedEffect(selectedCategory) { listState.animateScrollToItem(0) }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = productList, key = { product -> product.id }) { product ->
            ProductCard(
                product = product,
                onClick = {
                    //navController.navigate("product/${product.id}")
                    navController.navigate("product_vm/${product.id}")
                })
        }
    }

}
