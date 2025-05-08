package com.example.abbts2025.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.abbts2025.data.model.Review
import com.example.abbts2025.data.repository.addReview
import com.example.abbts2025.data.repository.getReviewsForProduct

@Composable
fun ReviewSection(productId: Int) {
    val reviews = remember {
        mutableStateListOf<Review>().apply {
            addAll(getReviewsForProduct(productId))
        }
    }

    var comment by remember { mutableStateOf(TextFieldValue("")) }
    var rating by remember { mutableStateOf(5) }
    var username by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
    ) {
        Text("Bewertungen", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        reviews.forEach {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text("${it.username} (${it.rating}/5)", style = MaterialTheme.typography.titleSmall)
                Text(it.comment, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Neue Bewertung", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text("Kommentar") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Bewertung:")
            Spacer(modifier = Modifier.width(8.dp))
            RatingSelector(rating) { rating = it }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val review = Review(productId, username.text, rating, comment.text)
            addReview(review)
            reviews.add(review)
            username = TextFieldValue("")
            comment = TextFieldValue("")
            rating = 5
        }) {
            Text("Absenden")
        }
    }
}

@Composable
fun RatingSelector(selected: Int, onSelected: (Int) -> Unit) {
    Row {
        (1..5).forEach {
            IconButton(onClick = { onSelected(it) }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart, // Optional: eigenes Stern-Icon verwenden
                    contentDescription = "$it Sterne",
                    tint = if (it <= selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}
