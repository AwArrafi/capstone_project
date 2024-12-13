package com.capstoneproject.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstoneproject.R
import com.capstoneproject.model.FavouriteItem
import com.capstoneproject.model.MenuItem

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val menuItem = intent.getParcelableExtra<MenuItem>("menu_item")
        val favouriteItem = intent.getParcelableExtra<FavouriteItem>("favourite_item")

        if (menuItem == null && favouriteItem == null) {
            finish()
            return
        }

        val itemImage: ImageView = findViewById(R.id.itemImage)
        val itemTitle: TextView = findViewById(R.id.itemTitle)
        val itemDescription: TextView = findViewById(R.id.itemDescription)

        menuItem?.let {
            itemImage.setImageResource(it.imageResId)
            itemTitle.text = it.title
            itemDescription.text = it.description
        }

        favouriteItem?.let {
            itemImage.setImageResource(it.imageResId)
            itemTitle.text = it.title
            itemDescription.text = it.description
        }
    }
}
