package com.example.abbts2025.data

import com.example.abbts2025.R

val productList = listOf(
    Product(
        id = 1,
        name = "Rote Äpfel",
        producer = "Obsthof Müller",
        category = Category.Obst, // <-- use enum, not String!
        description = "Frische, saftige rote Äpfel aus regionalem Anbau.",
        price = 2.99,
        priceFormatted = "CHF 2.99 / kg",
        unit = "kg",
        available = true,
        tags = listOf("regional", "bio", "saisonal"),
        imageResId = R.drawable.apfel
    ),
    Product(
        id = 2,
        name = "Bananen",
        producer = "Tropenimport AG",
        category = Category.Obst,
        description = "Reife Bananen mit natürlicher Süße – ideal für Smoothies.",
        price = 1.89,
        priceFormatted = "CHF 1.89 / kg",
        unit = "kg",
        available = true,
        tags = listOf("importiert", "frisch", "vitaminreich"),
        imageResId = R.drawable.bananen
    ),
    Product(
        id = 3,
        name = "Erdbeeren",
        producer = "Beerenhof Weber",
        category = Category.Obst,
        description = "Aromatische Erdbeeren – frisch gepflückt.",
        price = 3.49,
        priceFormatted = "CHF 3.49 / Schale",
        unit = "Schale (500g)",
        available = true,
        tags = listOf("regional", "bio", "Sommer"),
        imageResId = R.drawable.erdbeeren
    ),
    Product(
        id = 4,
        name = "Wassermelone",
        producer = "Melonen Union",
        category = Category.Obst,
        description = "Saftige Wassermelone – perfekt gekühlt im Sommer.",
        price = 4.99,
        priceFormatted = "CHF 4.99 / Stück",
        unit = "Stück",
        available = true,
        tags = listOf("sommerlich", "fruchtig", "erfrischend"),
        imageResId = R.drawable.wassermelone
    ),
    Product(
        id = 5,
        name = "Karotten",
        producer = "Biohof Keller",
        category = Category.Gemuese,
        description = "Knackige Bio-Karotten mit natürlicher Süße.",
        price = 1.49,
        priceFormatted = "CHF 1.49 / kg",
        unit = "kg",
        available = true,
        tags = listOf("bio", "regional", "vitamin A"),
        imageResId = R.drawable.karotten
    ),
    Product(
        id = 6,
        name = "Brokkoli",
        producer = "Gemüsepartner Schweiz",
        category = Category.Gemuese,
        description = "Frischer Brokkoli – reich an Vitaminen und Mineralstoffen.",
        price = 2.29,
        priceFormatted = "CHF 2.29 / Stück",
        unit = "Stück",
        available = true,
        tags = listOf("gesund", "grün", "faserreich"),
        imageResId = R.drawable.brokkoli
    ),
    Product(
        id = 7,
        name = "Weißkohl",
        producer = "Kohl-Kollektiv",
        category = Category.Gemuese,
        description = "Klassischer Weißkohl – ideal für Krautsalat oder Eintöpfe.",
        price = 1.99,
        priceFormatted = "CHF 1.99 / Stück",
        unit = "Stück",
        available = true,
        tags = listOf("klassisch", "regional", "ballaststoffreich"),
        imageResId = R.drawable.weisskohl
    ),
    Product(
        id = 8,
        name = "Paprika rot",
        producer = "Frischmarkt GmbH",
        category = Category.Gemuese,
        description = "Fruchtige rote Paprika – süß und knackig.",
        price = 2.79,
        priceFormatted = "CHF 2.79 / Stück",
        unit = "Stück",
        available = true,
        tags = listOf("bunt", "frisch", "antioxidantien"),
        imageResId = R.drawable.paprika
    ),
    Product(
        id = 9,
        name = "Grüne Oliven",
        producer = "Olivenhaus Kalamata",
        category = Category.Feinkost,
        description = "Mild eingelegte grüne Oliven – ideal für Tapas.",
        price = 3.95,
        priceFormatted = "CHF 3.95 / Glas",
        unit = "Glas (250g)",
        available = true,
        tags = listOf("feinkost", "mediterran", "salzig"),
        imageResId = R.drawable.oliven
    ),
    Product(
        id = 10,
        name = "Olivenöl Extra Vergine",
        producer = "La Vita Olio",
        category = Category.Feinkost,
        description = "Kaltgepresstes Olivenöl höchster Qualität aus Spanien.",
        price = 7.99,
        priceFormatted = "CHF 7.99 / Flasche",
        unit = "Flasche (500ml)",
        available = true,
        tags = listOf("spanisch", "nativ", "premium"),
        imageResId = R.drawable.olivenoel
    ),
    Product(
        id = 11,
        name = "Getrocknete Tomaten",
        producer = "Sonnenhof Italia",
        category = Category.Feinkost,
        description = "Sonnengereifte, aromatische Tomaten in Öl eingelegt.",
        price = 4.59,
        priceFormatted = "CHF 4.59 / Glas",
        unit = "Glas (200g)",
        available = true,
        tags = listOf("würzig", "intensiv", "italienisch"),
        imageResId = R.drawable.tomaten
    ),
    Product(
        id = 12,
        name = "Pesto mit Artischocken",
        producer = "Pesto e Basta",
        category = Category.Feinkost,
        description = "Cremiges Pesto aus Artischocken und feinem Käse.",
        price = 3.99,
        priceFormatted = "CHF 3.99 / Glas",
        unit = "Glas (190g)",
        available = true,
        tags = listOf("cremig", "veggie", "besonders"),
        imageResId = R.drawable.pesto
    )
)
