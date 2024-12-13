package com.capstoneproject.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstoneproject.R

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Ambil data dari Intent
        val resultLabel = intent.getStringExtra("RESULT") ?: "Unknown"

        // Data dummy untuk resep
        val recipeData = getRecipeData(resultLabel)

        // Referensi elemen UI
        val itemImage: ImageView = findViewById(R.id.itemImage)
        val itemTitle: TextView = findViewById(R.id.itemTitle)
        val itemDescription: TextView = findViewById(R.id.itemDescription)
        val ingredientsContent: TextView = findViewById(R.id.ingredientsContent)
        val methodsContent: TextView = findViewById(R.id.methodsContent)

        // Set data ke elemen UI
        itemImage.setImageResource(recipeData.imageRes)
        itemTitle.text = recipeData.title
        itemDescription.text = recipeData.description
        ingredientsContent.text = recipeData.ingredients
        methodsContent.text = recipeData.methods
    }

    // Fungsi untuk mendapatkan data resep berdasarkan label
    private fun getRecipeData(label: String): RecipeData {
        return when (label) {
            "Carrot" -> RecipeData(
                title = "Carrot Soup",
                description = "A healthy carrot soup packed with nutrients.",
                imageRes = R.drawable.carrot,
                ingredients = "Carrots\nOnions\nGarlic\nVegetable Broth",
                methods = "1. Chop carrots and onions.\n2. Sauté onions and garlic.\n3. Add carrots and broth.\n4. Simmer until tender and blend."
            )
            "Cabbage" -> RecipeData(
                title = "Cabbage Stir-Fry",
                description = "A quick and easy cabbage stir-fry.",
                imageRes = R.drawable.cabbage,
                ingredients = "Cabbage\nCarrots\nGarlic\nSoy Sauce",
                methods = "1. Chop cabbage and carrots.\n2. Sauté garlic.\n3. Add cabbage and carrots.\n4. Stir-fry with soy sauce."
            )
            "Papaya" -> RecipeData(
                title = "Papaya Salad",
                description = "A refreshing Thai papaya salad.",
                imageRes = R.drawable.papaya,
                ingredients = "Papaya\nTomatoes\nLime\nPeanuts",
                methods = "1. Shred papaya.\n2. Mix with chopped tomatoes.\n3. Add lime juice and peanuts.\n4. Serve fresh."
            )
            "Cauliflower" -> RecipeData(
                title = "Cauliflower Curry",
                description = "A flavorful cauliflower curry.",
                imageRes = R.drawable.cauliflower,
                ingredients = "Cauliflower\nOnions\nTomatoes\nCurry Powder",
                methods = "1. Chop cauliflower.\n2. Sauté onions and tomatoes.\n3. Add cauliflower and curry powder.\n4. Simmer until cooked."
            )
            else -> RecipeData(
                title = "Unknown Item",
                description = "No recipe available for this item.",
                imageRes = R.drawable.unknown,
                ingredients = "-",
                methods = "-"
            )
        }
    }

    // Data class untuk menyimpan informasi resep
    data class RecipeData(
        val title: String,
        val description: String,
        val imageRes: Int,
        val ingredients: String,
        val methods: String
    )
}
